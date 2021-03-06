package com.theoribeiro.cursomc;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.theoribeiro.cursomc.domain.Categoria;
import com.theoribeiro.cursomc.domain.Cidade;
import com.theoribeiro.cursomc.domain.Cliente;
import com.theoribeiro.cursomc.domain.Endereco;
import com.theoribeiro.cursomc.domain.Estado;
import com.theoribeiro.cursomc.domain.ItemPedido;
import com.theoribeiro.cursomc.domain.Pagamento;
import com.theoribeiro.cursomc.domain.PagamentoComBoleto;
import com.theoribeiro.cursomc.domain.PagamentoComCartao;
import com.theoribeiro.cursomc.domain.Pedido;
import com.theoribeiro.cursomc.domain.Produto;
import com.theoribeiro.cursomc.domain.enums.EstadoPagamento;
import com.theoribeiro.cursomc.domain.enums.TipoCliente;
import com.theoribeiro.cursomc.repositories.CategoriaRepository;
import com.theoribeiro.cursomc.repositories.CidadeRepository;
import com.theoribeiro.cursomc.repositories.ClienteRepository;
import com.theoribeiro.cursomc.repositories.EnderecoRepository;
import com.theoribeiro.cursomc.repositories.EstadoRepository;
import com.theoribeiro.cursomc.repositories.ItemPedidoRepository;
import com.theoribeiro.cursomc.repositories.PagamentoRepository;
import com.theoribeiro.cursomc.repositories.PedidoRepository;
import com.theoribeiro.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{ //utilizar CommanLineRunner para instanciar o BD

	// O REPOSITORY SALVA OS DADOS NO BD
	@Autowired //autodependencia
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private EstadoRepository estadorepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private PedidoRepository pedidorepository;
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception { //INSTANCIAR O BD
		
		//CLASSES CATEGORIA E PRODUTO
		Categoria cat1 = new Categoria(null,"Informática");
		Categoria cat2 = new Categoria(null,"Escritório");
		
		//INSTANCIAR OS PRODUTOS DAS CATEGORIAS
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		//ASSOCIAR AS CATEGORIAS AOS PRODUTOS
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3)); //ADICIONA P1,P2 E P3 A CATEGORIA 1
		cat2.getProdutos().addAll(Arrays.asList(p2)); //ADICIONA P2 A CATEGORIA 2
		
		//ASSOCIAR OS PRODUTOS AS CATEGORIAS
		p1.getCategorias().addAll(Arrays.asList(cat1)); //PRODUTO 1 PERTENCE A CATEGORIA 1
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2)); //PRODUTO 2 PERTENCE A CATEGORIA 1 e 2
		p3.getCategorias().addAll(Arrays.asList(cat1)); //PRODUTO 3 PERTENCE A CATEGORIA 1
		
		//REPOSITORY PARA SALVAR AS CATEGORIAS NO BD, FOI CRIADO LA EM CIMA (@AUTOWIRED)  
		//CRIADO NA CLASSE CategoriaRepository 
		categoriaRepository.save(Arrays.asList(cat1,cat2));
		
		//REPOSITORY PARA SALVAR OS PRODUTOS NO BD, FOI CRIADO LA EM CIMA (@AUTOWIRED)  
		//CRIADO NA CLASSE ProdutoRepository 
		produtoRepository.save(Arrays.asList(p1,p2,p3));
		
		//CLASSES ESTADO E CIDADE
		//INSTANCIAR ESTADO
		Estado est1 = new Estado(null,"Minas Gerais");
		Estado est2 = new Estado(null,"São Paulo");
		
		//INSTANCIAR CIDADE
		
		Cidade c1 = new Cidade(null, "Uberlândia",est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		
		//ASSOCIACAO ENTRE OS ESTADOS E AS CIDADES DE CADA ESTADO
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));
		
		//REPOSITORY PARA SALVAR OS ESTADOS NO BD, FOI CRIADO LA EM CIMA (@AUTOWIRED)  
		//CRIADO NA CLASSE EstadoRepository 
		estadorepository.save(Arrays.asList(est1,est2));// PRIMEIRO SALVA OS ESTADOS, JA QUE CADA CIDADE POSSUI O ID DO ESTADO
		
		//REPOSITORY PARA SALVAR AS CIDADES MO BD, FOI CRIADO LA EM CIMA (@AUTOWIRED)  
		//CRIADO NA CLASSE CidadeRepository
		cidadeRepository.save(Arrays.asList(c1,c2,c3));
		
		//CLASSES ENDERECO, CLIENTE E CIDADE
		
		//INSTANCIAR CLIENTE
		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "36378912377", TipoCliente.PESSOAFISICA);
		//ASSOCIAR CLIENTE E TELEFONE
		cli1.getTelefones().addAll(Arrays.asList("27363323", "93838393"));
		
		//INSTANCIAR ENDERECO
		Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 203", "Jardim", "38220834", cli1, c1);
		Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012", cli1, c2);
		
		//ASSOCIAR CLIENTE A ENDERECO
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		
		//REPOSITORY PARA SALVAR OS CLIENTES MO BD, FOI CRIADO LA EM CIMA (@AUTOWIRED) - CRIADO NA CLASSE ClienteRepository
		clienteRepository.save(Arrays.asList(cli1));
		
		//REPOSITORY PARA SALVAR OS ENDERECOS MO BD, FOI CRIADO LA EM CIMA (@AUTOWIRED) - CRIADO NA CLASSE EnderecoRepository
		enderecoRepository.save(Arrays.asList(e1, e2));
		
		//CLASSES PEDIDO, CLIENTE, ENDERECO E PAGAMENTO
		
		//CRIAR OBJETO AUXILIAR PARA SALVAR AS DATAS
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm"); //MASCARA DE FORMATACAO PARA INSTANCIAR UMA DATA
		
		//INSTANCIAR OS PEDIDOS
		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), cli1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:35"), cli1, e2);
		
		//INSTANCIAR OS PAGAMENTOS
		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		//INFORMAR A PEDIDO QUE EFETUOU UM PAGAMENTO
		ped1.setPagamento(pagto1);
		
		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"), null);
		ped2.setPagamento(pagto2);
		
		//ASSOCIAR OS CLIENTES AOS PEDIDOS
		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));
		
		//SALVAR PRIMEIRO OS PEDIDOS, POIS ELES SAO INDEPENDENTES
		pedidorepository.save(Arrays.asList(ped1, ped2));
		pagamentoRepository.save(Arrays.asList(pagto1, pagto2));
		
		//CLASSE ITEMPEDIDO, PRODUTO E PEDIDO
		
		//INSTANCIACAO DE ITEMPEDIDO
		ItemPedido ip1 = new ItemPedido(ped1, p1, 0.00, 1, 2000.00);
		ItemPedido ip2 = new ItemPedido(ped1, p3, 0.00, 2, 80.00);
		ItemPedido ip3 = new ItemPedido(ped2, p2, 100.00, 1, 800.00);
		
		//ASSOCIACAO ENTRE PEDIDO E ITEMPEDIDO
		ped1.getItens().addAll(Arrays.asList(ip1, ip2));
		ped2.getItens().addAll(Arrays.asList(ip3));
		
		//ASSOCIACAO ENTRE PRODUTO E ITEMPEDIDO
		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip3));
		p3.getItens().addAll(Arrays.asList(ip2));
		
		//CRIAR REPOSITORY PARA SALVAR OS ITENS DE PEDIDO NO BD
		itemPedidoRepository.save(Arrays.asList(ip1, ip2, ip3));
		
		
	}

}
