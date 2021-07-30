 

import java.util.Scanner;
import java.util.Arrays;
public class Trabalho1 {

	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		int cont = 0,i=0,menu=1;
		String nomes[]=new String[100];
		String produtos[]=new String[100];
		String desc[] = new String[100];
		String end[]=new String[100];
		String tel[]=new String[100];
		int valor[]=new int[100];
		int porc[]=new int[100];
		String nomePesquisa;
		String produtoPesquisa;
		String escolhaCliente;
		String escolha2Produto;
		int escolha,quant = 0,escolhaProduto;
		int estoc[]=new int[100];
		boolean search = true;
		boolean searchProduct=true;
		boolean search2 = true;
		boolean searchProduct2=true;
		int qntdVendida;
		int continua;
		int totalEstoque=0;
		int z=0 , y=0 , v=0, k=0 , p=0 ,u=0,l=0,c=0,s,n;
		
		//Pre cadastro dos clientes para o teste
		for(int q=0;q<10;q++) {
			nomes[q]="cliente"+(q+1);
			end[q]="endereço"+(q+1);
			tel[q]="9999999"+(q+1);
			
			p++;
		}
		z=p;
		
		//Pre cadastro dos produtos para o teste
		for(int r=0;r<10;r++) {
			produtos[r]="produto"+(r+1);
			desc[r]="descriçao"+(r+1);
			valor[r]=100*(r+1);
			porc[r]=50-(r+1);
			estoc[r]=10+r;
			totalEstoque=totalEstoque+estoc[r];
			y++;
		}
		u=y;
		
		do {
			//Menu
			System.out.println("MENU");
			System.out.println("1- Cadastro de clientes");
			System.out.println("2-Busca por cliente");
			System.out.println("3-Cadastro de novo produto");
			System.out.println("4-Busca por produtos");
			System.out.println("5-Cadastro de vendas");
			System.out.println("6-Mostrar produtos em estoque");
			System.out.println("7-Sair do programa");
			menu=ler.nextInt();
		
		switch(menu) {
			case 1:
				//Case para o cadastro de novos clientes
				System.out.println("Quantos clientes serao cadastrados ?");
				cont=ler.nextInt();
				ler.nextLine();
				for(i=z;i<z+cont;i++) {
					System.out.println("Digite o nome do cliente:");
					nomes[i]=ler.nextLine();
					System.out.println("Digite o endereço do cliente:");
					end[i]=ler.nextLine();
					System.out.println("Digite o telefone do cliente:");
					tel[i]=ler.nextLine();
					p++;
				}
				z=p;
				
				break;
		case 2:
				//Case para a pesquisa de clientes
				ler.nextLine();
				System.out.println("Digite o nome do cliente:");
				nomePesquisa=ler.nextLine();
				for(k=0;k<z;k++) {
					if(nomes[k].equals(nomePesquisa)) {
						search=true;
						break;
					}else {
						search=false;
						}
				}
					if(search==true) {
						System.out.println("Cliente achado");
						System.out.println(nomes[k]+ " - "+end[k]+" - "+tel[k]);
						System.out.println("Se quiser trocar dados do cliente tecle (1),se nao tecle qualquer outro numero");
						escolha=ler.nextInt();
						if(escolha==1) {
							ler.nextLine();
							System.out.println("Digite o  novo nome do cliente:");
							nomes[k]=ler.nextLine();
							System.out.println("Digite o novo endereço do cliente:");
							end[k]=ler.nextLine();
							System.out.println("Digite o novo telefone do cliente:");
							tel[k]=ler.nextLine();
							break;
						}else {
							break;
						}
					}else if(search==false) {
						System.out.println("Cliente nao cadastrado");
						break;
					}
				
		
				break;
			case 3:
				//Case para cadastro de novos produtos
				System.out.println("Digite a quantidade de produtos a serem cadastrados");
				quant=ler.nextInt();
				for(v=u;v<u+quant;v++) {
					ler.nextLine();
					System.out.println("Digite o nome do produto");
					produtos[v]=ler.nextLine();
					System.out.println("De a descricao do produto");
					desc[v]=ler.nextLine();
					System.out.println("Digite o  valor de compra do produto");
					valor[v]=ler.nextInt();
					System.out.println("Digite a porcentagem de lucro");
					porc[v]=ler.nextInt();
					System.out.println("Digite a quantidade em estoque");
					estoc[v]=ler.nextInt();
					totalEstoque=totalEstoque+estoc[v];
					y++;
				}
					u=y;
				break;
				
			case 4:
				//Case para pesquisa de produtos
				ler.nextLine();
				System.out.println("Digite o nome do produto:");
				produtoPesquisa=ler.nextLine();
				for(l=0;l<u;l++) {
					if(produtos[l].equals(produtoPesquisa)) {
						searchProduct=true;
						break;
					}else {
						searchProduct=false;
						}
					}
				if(searchProduct==true) {
					System.out.println("produto achado");
					System.out.println(produtos[l]+ " - "+desc[l]+" -  R$"+valor[l]+" - "+porc[l]+"%   - "+estoc[l]);
					System.out.println("Se quiser trocar dados do produto tecle (1)");
					escolhaProduto=ler.nextInt();
					if(escolhaProduto==1) {
						ler.nextLine();
						totalEstoque=totalEstoque-estoc[l];
						System.out.println("Digite o novo nome do produto");
						produtos[l]=ler.nextLine();
						System.out.println("De a descricao do produto");
						desc[l]=ler.nextLine();
						System.out.println("Digite o  valor de compra do produto");
						valor[l]=ler.nextInt();
						System.out.println("Digite a porcentagem de lucro");
						porc[l]=ler.nextInt();
						System.out.println("Digite a quantidade em estoque");
						estoc[l]=ler.nextInt();
						totalEstoque=totalEstoque+estoc[l];
						break;
					}else {
						break;
					}
					
				}else if(searchProduct==false) {
					System.out.println("Produto nao cadastrado");
					break;
				}
				
			case 5:
				//Case para o cadastro de novas vendas
				continua=1;
				do {
				ler.nextLine();
				System.out.println("Escolha entre os clientes a seguir:");
				for(c=0;c<z;c++) {
					System.out.println(nomes[c]);
				}
				System.out.println("Digite o nome do cliente que deseja escolher");
				System.out.println("Se o cliente nao for encontrado retornara ao menu");
				escolhaCliente=ler.nextLine();
				for(s=0;s<z;s++) {
					if(nomes[s].equals(escolhaCliente)) {
						search2=true;
						break;
					}else {
						search2=false;
						}
				}
				if(search2==true) {
						
							System.out.println("Escolha entre os produtos a seguir ");
							for( n =0;n<u;n++) {
								System.out.println(produtos[n]+" em estoque: "+estoc[n]);
							}
							System.out.println("Digite o nome do produto que deseja escolher");
							escolha2Produto=ler.nextLine();
							for( n=0;n<u;n++) {
								if(produtos[n].equals(escolha2Produto)) {
									searchProduct2=true;
									break;
								}else {
									searchProduct2=false;
								}
							}
							if(searchProduct2==true) {
								System.out.println("Digite a quantidade desse produto que foi vendida a esse cliente");
								qntdVendida=ler.nextInt();
								
								if(estoc[n]>=qntdVendida) {
									estoc[n]= estoc[n] - qntdVendida;
									totalEstoque=totalEstoque-qntdVendida;
									System.out.println("Digite 1 se deseja cadastrar mais vendas ,se nao digite 2");
									continua=ler.nextInt();
									if(continua != 1) {
										break;
									}
								}else if(estoc[n]<qntdVendida){
									System.out.println("Quantidade insuficiente no estoque");
									System.out.println(" tente novamente");
									break;
								}
							}else if(searchProduct2==false) {
								System.out.println("Produto nao encontrado , retornando ao menu");
								break;
							}	
					}else if(search2==false) {
								System.out.println("Cliente nao encontrado , retornando ao menu");
								break;
					}
				}while(continua==1);
				break;
			case 6:
				//Case para ver a quantidade em estoque
				System.out.println("O total de produtos em estoque e:"+ totalEstoque);
				for(int w=0;w<u;w++) {
					System.out.println(produtos[w] + " em estoque: " + estoc[w]);
				}
				break;
			case 7:
				System.out.println("Obrigado por usar o programa !!! Saindo...");
				
		}
		}while(menu<7 && menu>=1);
		
		// TODO Auto-generated method stub

	}

}
