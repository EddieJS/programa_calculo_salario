package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.WorkerLevel;

public class Worker {
	// A classe workers tem 2 associações: Department e Hour Contract
	
	//Inserção dos ATRIBUTOS básicos
	private String name;
	private WorkerLevel level;
	private Double baseSalary;
	
	//Agora serão inseridas as ASSOCIAÇÕES: Department e Hour Contract 
	private Department department; 
	private List<HourContract> contracts = new ArrayList<>();
	
	//agora inserir um construtor padrão
	public Worker() {
	}

	//Gerar um construtor, mas sem colocar uma lista (que neste caso é o CONTRACTS)
	//Após gerar o contrutor, tem que instanciar o contracts da linha 17, porque a lista precisa ser instanciada (new ArrayList<>()) já na declaração do meu atributo, em seguida importar o ArrayList ctrl +shift + o
	public Worker(String name, WorkerLevel level, Double baseSalary, Department department) {
		
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkerLevel getLevel() {
		return level;
	}

	public void setLevel(WorkerLevel level) {
		this.level = level;
	}

	public Double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<HourContract> getContracts() {
		return contracts;
	}

	
	
	
	
	//Próximo passo é implementar os métodos da CLASSE WORKER:
	//PASSO 1. addContract recebendo um contrato como argumento, ou seja, éum método criado para associar um contrato a esse trabalhador
	
	public void addContract(HourContract contract) {
	//Este método vai pegar a lista de contratos da linha 17 (contracts) e adicionar ao contrato que veio como argumento (contract) da linha de cima
		contracts.add(contract);
	}
	
	//PASSO 2. removeContract recebendo um contrato, este método vai ter que remover o contrato informado dos contratos associados ao trabalhador (Worker)
	public void removeContract(HourContract contract) {
		contracts.remove(contract);
		
	
	//IMPORTANTE. Os métodos 1 e 2 são responsáveis por fazer e desfazer a associação de contratos do trabalhador 
		
	//IMPORTANTE. Não podemos deixar a operação "public void setContracts(List<HourContract> contracts) {this.contracts = contracts;}" da linha 70
		//porque a minha lista de contratos do trabalhador, inicialmente vai ser instanciada como lista vazia e depois vou poder adionar e remover (linhas 77 e 83) contratos dessa lista
		//mas, de maneira alguma, posso permitir que essa lista seja trocada. No caso de usar o setContracts, ele vai atribuir uma lista a minha lista de contratos (contracts) do trabalhador
	}
	
	//PASSO 3. income(year: Integer, month: Integer): Double. Essa operação vai calcular quanto a pessoa ganhou baseado em um ano e um mês
		//O trabalhador tem o salário base (baseSalary, linha 14), só que o quanto ele ganhou no mês é o salario base + o tanto que ele ganhou nos contratos (linha 18) daquele mês
	public double income(int year, int month) {
		//passo 1. declarar uma variável soma recebendo o salário base (baseSalary) desse funcionário
		double sum = baseSalary;
		//passo 2. agora vou ter que pecorrer os contratos desse funcionário testanto quais os contratos que são do mês e do ano inseridos Quando ele encontrar, ele vai entrar nessa soma (linha 98) 
		Calendar cal = Calendar.getInstance();
		for(HourContract c : contracts) {
			//o contrato tem uma data (aba HourContract.java, linha 9) onde eu pego o ano e o mês dessa data
			//o contrato também tem uma operação (valor total - totalValue():Double) e é essa operação que vai me devolver o valor total do contrato, mas
			  //ela ainda não foi implementada e deve ser feito agora na aba HourContract.java.
			
			//Se fosse somente acrescentar todos os contratos a essa soma, a operação seria somente isso:
				//sum += c.totalValue(){ }
				//return sum;
			//Mas, eu não quero o valor de todos os contratos, somente aquele do mês e do ano que eu selecionar (linha 96)
			//Então, preciso incluir uma condição:
			cal.setTime(c.getDate());
			int c_year = cal.get(Calendar.YEAR);
			int c_month = 1 + cal.get(Calendar.MONTH);	
			if (year == c_year && month == c_month) {
					sum += c.totalValue();
				}
		}
		return sum;
	}
	
	
	
	
	
	
	
	
	
}
