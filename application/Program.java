package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {
	
	public static void main(String[] args) throws ParseException {
		
//Este é o início da última fase do projeto
		
		Locale.setDefault(Locale.US);		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
		
		
		//Agora inserir os comendos que recebem o que o usuário irá digitar
		System.out.print("Enter department's name: ");
		String departmentName = sc.nextLine();
		
		System.out.println("Enter worker data: ");
		System.out.print("Name: ");
		String workerName = sc.nextLine();
		
		System.out.print("Level: ");
		String workerLevel = sc.nextLine();
		System.out.print("Base salary: ");
		double baseSalary = sc.nextDouble();
		
		//Com base nisso, agora já posso instanciar meu trabalhador (Worker)
		Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Department(departmentName));
		
		//Agora, o programa tem que perguntar quantos contratos são para este trabalhador
		
		System.out.print("How many contracts to this worker? ");
		int n = sc.nextInt();
		
		//Agora, para ler os dados do contrato, criamos um "for()"
		for(int i=1; i<=n; i++) {
			//Agora, fazer a leitura dos contratos
			System.out.println("Enter contract #" + i + " data:");
			System.out.print("Date (DD/MM/YYYY): ");
			
			//Agora, vamos ler uma variável do tipo "Date" o que o usuário vai digitar no campo de data acima e para isso
			//precisa criar um simple date format. Está na linha 18.
			Date contractDate = sdf.parse(sc.next());
			System.out.print("Value per hour: ");
			double valuePerHour = sc.nextDouble();
			//agora, precisamos saber da duração do contrato
			System.out.print("Duration (hours): ");
			int hours = sc.nextInt();
			
			//Agora, com os valores de DATA, VALOR POR HORA E DURAÇÃO, já pode instanciar o contrato
			HourContract contract = new HourContract(contractDate, valuePerHour, hours);
			//Agora, para assossiar este contrato ao trabalhor:
			worker.addContract(contract);
		}
		
		System.out.println(); //Apenas uma quebra de linha
		System.out.print("Enter month and year to calculate income (MM/YYYY): ");
		String monthAndYear = sc.next();
		
		//Agora, pegar a String "MM" e "YYYY" e converter para int (inteiro)
		int month = Integer.parseInt(monthAndYear.substring(0, 2));
		int year = Integer.parseInt(monthAndYear.substring(3));
		
		//Agora, imprimir o resultado da operação
		System.out.println("Name: " + worker.getName());
		System.out.println("Department: " + worker.getDepartment().getName());
		System.out.println("Income for " + monthAndYear + ": " + String.format("%.2f", worker.income(year, month))); //para que esse valor apareça com duas casas decimais
		//tem que chamar o String.format("%2f", ...
				
				
		sc.close();
	}
	
//AULA 148 DO CURSO
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
