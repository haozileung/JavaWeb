package com.haozileung.jbloger.common.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;

import org.apache.struts2.ServletActionContext;

//验证码
public class SecurityCode {
	private String securityCode;
	public SecurityCode(){

	}
	Color getRandColor(int fc, int bc) {
		Random random = new Random();
		if (fc > 255)
			fc = 255;
		if (bc > 255)
			bc = 255;
		int r = fc + random.nextInt(bc - fc);
		int g = fc + random.nextInt(bc - fc);
		int b = fc + random.nextInt(bc - fc);
		return new Color(r, g, b);
	}
	public void CreateCode()throws Exception{
		try {
			ServletActionContext.getResponse().setHeader("Pragma", "No-cache");
			ServletActionContext.getResponse().setHeader("Cache-Control", "no-cache");
			ServletActionContext.getResponse().setDateHeader("Expires", 0);
			int width = 60, height = 20;
			BufferedImage image = new BufferedImage(width, height,
					BufferedImage.TYPE_INT_RGB);
			OutputStream os = ServletActionContext.getResponse().getOutputStream();
			Graphics g = image.getGraphics();
			Random random = new Random();
			g.setColor(getRandColor(200, 250));
			g.fillRect(0, 0, width, height);

			g.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			g.setColor(getRandColor(160, 200));
			for (int i = 0; i < 155; i++) {
				int x = random.nextInt(width);
				int y = random.nextInt(height);
				int xl = random.nextInt(12);
				int yl = random.nextInt(12);
				g.drawLine(x, y, x + xl, y + yl);
			}
			String[] code = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a",
					"b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o",
					"p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C",
					"D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q",
					"R", "S","T","U","V","W","X","Y","Z", };
			
			String sRand = "";
			for (int i = 0; i < 4; i++) {
				String rand = String.valueOf(code[random.nextInt(62)]);
				sRand += rand;
				g.setColor(new Color(20 + random.nextInt(110), 20 + random
						.nextInt(110), 20 + random.nextInt(110)));
				g.drawString(rand, 13 * i + 6, 16);
			}
			
			this.securityCode = "sRand";
			g.dispose();
			ImageIO.write(image, "JPEG", os);
            System.out.println("fsdfds");
			//注意看以下几句的使用  
			os.flush();
			os.close();
			os = null;
			ServletActionContext.getResponse().flushBuffer();
			ServletActionContext.getPageContext().pushBody();
			ServletActionContext.getRequest().getSession().setAttribute("rand", sRand);
		} catch (IllegalStateException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}	
	}
	public String getSecurityCode() throws Exception{
		return securityCode;
	}
	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}
	
}
