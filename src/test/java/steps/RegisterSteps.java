package steps;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Quando;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import register.RegisterPage;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.time.Duration;

public class RegisterSteps {

    WebDriver driver;
    RegisterPage registerPage;

    @Before("@Register")
    public void abrirBrowser(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));

       }
   @After("@Register")
        public void fecharBrowser(){
        driver.quit();

     }
     @AfterStep("@Register")
    public void print(){
        TakesScreenshot screenshot = ((TakesScreenshot) driver); // Convertendo o driver em TakesScreenshot
        byte[] printBytes = screenshot.getScreenshotAs(OutputType.BYTES);
        InputStream printStream = new ByteArrayInputStream(printBytes);
        Allure.addAttachment("Register",printStream);
    }

    @Dado("que eu acesso o site Register")
    public void queEuAcessoOSiteRegister() {
     driver.get("https://demo.automationtesting.in/Register.html");

    }
    @Quando("preencho nome {string} e sobrenome: {string}")
    public void preenchoNomeESobrenome(String nome, String sobrenome) {
        registerPage = new RegisterPage(driver);
        registerPage.preencherNome(nome);
        registerPage.preencherSobreNome(sobrenome);
    }

    @E("preencho campo endereço com o valor {string}")
    public void preenchoCampoEndereçoComOValor(String end) {
        registerPage.preencherEndereco(end);
    }

    @E("preencho campo email com o valor {string}")
    public void preenchoCampoEmailComOValor(String email) {
        registerPage.preencherEmail(email);
    }

    @E("preencho campo telefone com o valor {string}")
    public void preenchoCampoTelefoneComOValor(String tel) {
        registerPage.preencherPhone(tel);
    }

    @E("clico no checkbox FeMale, clico no checkbox Movies")
    public void clicoNoCheckboxFeMaleClicoNoCheckboxMovies() {
        registerPage.clicarGender();
        registerPage.clicarHobbies();
    }

    @E("seleciono a Skills {string}")
    public void selecionoASkills(String skill) {
        registerPage.selecionarSkills(skill);
    }

    @E("seleciono um country")
    public void selecionoUmCountry() {
        registerPage.clicarCountry();
    }

    @E("seleciono o ano {string}, o mes {string}, e o dia {string}")
    public void selecionoOAnoOMesEODia(String ano, String mes, String dia) {
        registerPage.selecionarAno(ano);
        registerPage.selecionarMes(mes);
        registerPage.selecionarDia(dia);
    }
}
