package triangulo;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class TesteTriangulo {

	@Test
	public void test() throws MalformedURLException {
		// informar a app
		File diretorio = new File("c://Selenium//apps");
		File app = new File(diretorio, "TrianguloApp.apk");
		
		// capacidades
		DesiredCapabilities capacidades = new DesiredCapabilities();
		capacidades.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		capacidades.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		capacidades.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
		
		// sessao
		AndroidDriver<WebElement> driver = 
				new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capacidades);
		
		// interação com componentes
		driver.findElement(By.id("com.eliasnogueira.trianguloapp:id/txtLado1")).sendKeys("3");
		driver.findElement(By.id("com.eliasnogueira.trianguloapp:id/txtLado2")).sendKeys("3");
		driver.findElement(By.id("com.eliasnogueira.trianguloapp:id/txtLado3")).sendKeys("3");
		driver.findElement(By.id("com.eliasnogueira.trianguloapp:id/btnCalcular")).click();
		
		assertEquals("O triângulo é Equilátero", driver.findElement(By.id("com.eliasnogueira.trianguloapp:id/txtResultado")).getText());
		
		
	}

}
