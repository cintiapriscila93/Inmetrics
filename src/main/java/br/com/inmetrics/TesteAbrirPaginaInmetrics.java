package br.com.inmetrics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TesteAbrirPaginaInmetrics {

	public static void main(String[] args) throws InterruptedException {
		
		//Configurando servidor do Selenium no contexto da aplicação
		System.setProperty("webdriver.gecko.driver", "C:\\app\\selenium\\geckodriver.exe");
		
		//Criando Webdriver do Firefox
		WebDriver driverFirefox = new FirefoxDriver();
		driverFirefox.get("http://www.google.com.br");
		
		//Buscando campo de busca do Google para pesquisa
		WebElement campoBuscaGoogle = driverFirefox.findElement(By.name("q"));
		campoBuscaGoogle.sendKeys("Inmetrics");
		
		//Aguardando carregamento por 10 segundos da busca do Google 		
		new WebDriverWait(driverFirefox, 10).until(ExpectedConditions.presenceOfElementLocated(By.id("resultStats")));

		//Filtrando os links encontrados com a regex
	    List<WebElement> listalinks = driverFirefox.findElements(By.xpath("//*[@id='rso']//h3/a"));

	    //Buscando pelo link da inmetrics na lista de links encontrados
	    for (WebElement webElement : listalinks)
	    {
	    	if("http://www.inmetrics.com.br/".equalsIgnoreCase(webElement.getAttribute("href"))){
	    		webElement.click();
	    		break;
	    	}
	    }		
	}
}
