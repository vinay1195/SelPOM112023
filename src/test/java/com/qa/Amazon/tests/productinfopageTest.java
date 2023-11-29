package com.qa.Amazon.tests;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.Amazon.pages.productinfopage;

public class productinfopageTest extends BaseTest {
	@BeforeClass
	public void LoginPasswordpageSetup() {
		loginpwdpage = loginpage.doLoginEmailPage(prop.getProperty("username"));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void LoginPassworTest() {
		loginpwdpage.doLoginpwdSignin(prop.getProperty("pwd"));

	}

	/*
	 * @DataProvider public Object[][] productSelectData() { return new Object[][] {
	 * { "LG",
	 * "Replacement LG Remote Control for Smart TV,LG Magic Remote AN-MR22GA with Voice and Pointer Function,Compatible for 2022-2019 LG TVs,OLED,QNED,NANOCell etc."
	 * }, { "SamSung",
	 * "SAMSUNG Galaxy A54 5G A Series Cell Phone, Factory Unlocked Android Smartphone, 128GB w/ 6.4” Fluid Display Screen, Hi Res Camera, Long Battery Life, Refined Design, US Version, 2023, Awesome Violet"
	 * } }; }
	 * 
	 * @Test(dataProvider = "productSelectData") public void
	 * selectProductTest(String productname, String mainProductName) { Searchpage =
	 * loginpwdpage.doSearch(productname); //
	 * System.out.println("my product name is"+productname); productinfo =
	 * Searchpage.selectProduct(mainProductName);
	 * Assert.assertEquals(productinfo.isElementExist(), mainProductName); //
	 * productinfo.isElementExist(); }
	 */
	@Test
	public void productinfo() throws InterruptedException 
	{
		Searchpage=loginpwdpage.doSearch("LG");
		Thread.sleep(5000);
		productinfo=Searchpage.selectProduct("Replacement LG Remote Control for Smart TV,LG Magic Remote AN-MR22GA with Voice and Pointer Function,Compatible for 2022-2019 LG TVs,OLED,QNED,NANOCell etc.");
		ArrayList<String> Actproductifo = productinfo.productMetada();
	System.out.println(Actproductifo.size());
		
		for(int i=0;i<Actproductifo.size();i++)
		{   if(i==0||i==2||i==4||i==6||i==8)
			{
			System.out.print(Actproductifo.get(i));
			}
		else
		{
			System.out.println(" ---> "+Actproductifo.get(i));
		}
		}
			
	}
	
}
