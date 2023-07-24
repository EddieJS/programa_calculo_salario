package entities;

import java.util.Date;

public class HourContract {

	// Atributos da Classe Hour Contract

	private Date date;
	private Double valuePerHour;
	private Integer hours;

	public HourContract() {

	}

	public HourContract(Date date, Double valuePerHour, Integer hours) {

		this.date = date;
		this.valuePerHour = valuePerHour;
		this.hours = hours;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getValuePerHour() {
		return valuePerHour;
	}

	public void setValuePerHour(Double valuePerHour) {
		this.valuePerHour = valuePerHour;
	}

	public Integer getHours() {
		return hours;
	}

	public void setHours(Integer hours) {
		this.hours = hours;
	}
	
	public double totalValue() { //essa operação consiste em multiplicar o valor por hora ($$) pela quantidade de horas  
		return valuePerHour * hours;
		
		//totalValue. aqui foi implementado o conceito de delegação, ou seja, quem é a classe responsável por saber o valor total de um contrato?
		  //Tem que ser a própria classe contrato (na aba HourContract.java), não pode ser a classe trabalhador (Worker.java)
	}

}
