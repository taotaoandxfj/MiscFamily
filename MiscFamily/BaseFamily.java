package cn.ctf.mics;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.URLEncoder;

import javax.management.RuntimeErrorException;
import javax.swing.ImageIcon;

import sun.misc.BASE64Decoder;
//import sun.misc.BASE64Encoder;


import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Base32;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.net.URLCodec;


//加密类
 class MiscEncode{
	/**
	 * base16加密
	 */
	private byte[] src;
	private String OrgingStr;
	MiscEncode(byte[] src){
		this.src=src;
	}
	MiscEncode(String orString){
		this.OrgingStr=OrgingStr;
	}
	 public String encode_16()throws Exception {
	        StringBuffer strbuf = new StringBuffer(src.length * 2);
	        int i;

	        for (i = 0; i < src.length; i++) {
	            if (((int) src[i] & 0xff) < 0x10)
	                strbuf.append("0");

	            strbuf.append(Long.toString((int) src[i] & 0xff, 16));
	        }

	        return strbuf.toString();
	    }
	 
/*
 * ==============================================================================	 
 */
	 /**
	  * base32加密
	  */
	 public String encode_32(){
		 Base32 base32=new Base32();
			String text1=OrgingStr;
			byte[] b_32=text1.getBytes();
			b_32=base32.encode(b_32);
			String text3=new String(b_32);
			return text3;
	 }
/*
 * ==============================================================================	
 */
	 /**
	  * base64加密
	  */
	 public String encode_64(){
		 Base64 base64=new Base64();
			String text1=OrgingStr;
			byte[] b_64=text1.getBytes();
			b_64=base64.encode(b_64);
			String text2=new String(b_64);
			return text2;
	 }
}
 //解密类
 class MiscDecode{
	 private String str;
	 MiscDecode(String str){
		 this.str=str;
	 }
	 public byte[] decode()throws Exception {
	        byte[] bts = new byte[str.length() / 2];
	        for (int i = 0; i < bts.length; i++) {
	            bts[i] = (byte) Integer.parseInt(str.substring(2 * i, 2 * i + 2), 16);
	        }
	        return bts;
	    }
 }
//装饰类用于装束Frame
 class DecorateFrame{
	 	private Label lab1;
		private Label lab2;
		private Label lab3;
		private Label lab4;
		private Label lab5;
		private Label lab6;
		private Label lab7;
		private Label lab8;
		
		private TextField tf1;
		private TextField tf2;
		private TextField tf3;
		private TextField tf4;
		private TextField tf5;
		private TextField tf6;
		private TextField tf7;
		private TextField tf8;
		
		private Button but1;
		private Button but2;
		private Button but3;
		private Button but4;
		private Button but5;
		private Button but6;
		private Button but7;
		private Button but8;
		
		public DecorateFrame(){
			lab1=new Label("请输入源字符串:");
			lab2=new Label("base64加密: ");
			lab3=new Label("base32加密: ");
			lab4=new Label("base16加密: ");
			lab5=new Label("16进制加密:  ");
			lab6=new Label("MD5_32加密:");
			lab7=new Label("SHA1加密:    ");
			lab8=new Label("URL加密:      ");
			
			tf1=new TextField(50);
			tf2=new TextField(50);
			tf3=new TextField(50);
			tf4=new TextField(50);
			tf5=new TextField(50);
			tf6=new TextField(50);
			tf7=new TextField(50);
			tf8=new TextField(50);
			
			but1=new Button("给我转");
			but2=new Button("还原");
			but3=new Button("还原");
			but4=new Button("还原");
			but5=new Button("还原");
			but6=new Button("不会");
			but7=new Button("不会");
			but8=new Button("还原");
		}
		public Label getLab1() {
			return lab1;
		}
		public Label getLab2() {
			return lab2;
		}
		public Label getLab3() {
			return lab3;
		}
		public Label getLab4() {
			return lab4;
		}
		public Label getLab5() {
			return lab5;
		}
		public Label getLab6() {
			return lab6;
		}
		public Label getLab7() {
			return lab7;
		}
		public Label getLab8() {
			return lab8;
		}
		public TextField getTf1() {
			return tf1;
		}
		public TextField getTf2() {
			return tf2;
		}
		public TextField getTf3() {
			return tf3;
		}
		public TextField getTf4() {
			return tf4;
		}
		public TextField getTf5() {
			return tf5;
		}
		public TextField getTf6() {
			return tf6;
		}
		public TextField getTf7() {
			return tf7;
		}
		public TextField getTf8() {
			return tf8;
		}
		public Button getBut1() {
			return but1;
		}
		public Button getBut2() {
			return but2;
		}
		public Button getBut3() {
			return but3;
		}
		public Button getBut4() {
			return but4;
		}
		public Button getBut5() {
			return but5;
		}
		public Button getBut6() {
			return but6;
		}
		public Button getBut7() {
			return but7;
		}
		public Button getBut8() {
			return but8;
		}
		
		
 }
public class BaseFamily {
	/**
	 * 感觉这个类太冗杂了，后面的版本中一定要改善
	 * @param args
	 */
	private Frame f;
	
	
	
	public BaseFamily() {
		init();
	}

	DecorateFrame df=new DecorateFrame();
	public void init() {
		//窗口基本配置
		f=new Frame("base family");
		f.setBounds(400, 400, 600, 500);
		f.setLayout(new FlowLayout());
		
		f.add(df.getLab1());
		f.add(df.getTf1());
		f.add(df.getBut1());
		
		f.add(df.getLab2());
		f.add(df.getTf2());
		f.add(df.getBut2());
		
		f.add(df.getLab3());
		f.add(df.getTf3());
		f.add(df.getBut3());
		
		f.add(df.getLab4());
		f.add(df.getTf4());
		f.add(df.getBut4());
		
		f.add(df.getLab5());
		f.add(df.getTf5());
		f.add(df.getBut5());
		
		f.add(df.getLab6());
		f.add(df.getTf6());
		f.add(df.getBut6());
		
		f.add(df.getLab7());
		f.add(df.getTf7());
		f.add(df.getBut7());
		
		f.add(df.getLab8());
		f.add(df.getTf8());
		f.add(df.getBut8());
		
		
		Event();
		
		//显示窗口
		f.setVisible(true);
	}


	public void Event() {
		
		//关闭程序
		f.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				
				System.exit(0);
			}
			
		});
		//base64加密(鼠标点击事件)
		df.getBut1().addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				
				Base64_Lock();
				Base32_Lock();
				try {
					Base16_Lock();
				} catch (Exception e1) {
					throw new RuntimeException("base16编码失败");
				}
				Hex_Lock();
				Md5_Lock();
			    Sha1_Lock();
			    try {
					Url_Lock();
				} catch (EncoderException e1) {
					throw new RuntimeException("url编码异常");
				}
			}
			/**
			 * 普通字符的url加密
			 * @throws EncoderException 
			 */
			public void Url_Lock() throws EncoderException {
				String text=df.getTf1().getText();
				URLCodec urlcode=new URLCodec();
				String urlString=urlcode.encode(text);
				df.getTf8().setText(urlString);
			}
			/**
			 * SHA1加密
			 */
			public void Sha1_Lock() {
				String text1=df.getTf1().getText();
				String sha1String=DigestUtils.sha1Hex(text1);
				df.getTf7().setText(sha1String);
			}
			/**
			 * md5_32加密
			 */
			public void Md5_Lock() {
				String text1=df.getTf1().getText();
				String md5String=DigestUtils.md5Hex(text1);
				df.getTf6().setText(md5String);
			}
			/**
			 * Hex加密:
			 */
			
			public void Hex_Lock() {
				String text1=df.getTf1().getText();
				String hexString=Hex.encodeHexString(text1.getBytes());
				df.getTf5().setText(hexString);
			}
			/**
			 * Base16加密
			 * @throws Exception 
			 */
			public void Base16_Lock() throws Exception {
				
				String text1=df.getTf1().getText();
				byte[] b_16=text1.getBytes();
				MiscEncode me=new MiscEncode(b_16);
				String text4=me.encode_16();
				df.getTf4().setText(text4);
			}
			/**
			 * base32加密
			 */
			public void Base32_Lock() {
				//第一种方式
				Base32 base32=new Base32();
				String text1=df.getTf1().getText();
				byte[] b_32=text1.getBytes();
				b_32=base32.encode(b_32);
				String text3=new String(b_32);
				df.getTf3().setText(text3);
			}

			/**
			 * base64加密
			 * 
			 */
			public void Base64_Lock() {
				
				Base64 base64=new Base64();
				String text1=df.getTf1().getText();
				byte[] b_64=text1.getBytes();
				b_64=base64.encode(b_64);
				String text2=new String(b_64);
				df.getTf2().setText(text2);
				
			}
			
		});
		
		
		//base64解密
		df.getBut2().addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				String decode_64=null;
				String text2=df.getTf2().getText();
				BASE64Decoder decoder=new BASE64Decoder();
				try {
					 decode_64=new String(decoder.decodeBuffer(text2));
				} catch (IOException e1) {
					throw new RuntimeException("base64解密失败，请重试");
				}
				df.getTf1().setText(decode_64);
			}
			
		});
		
		//base32解密
		df.getBut3().addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				try{
				Base32 base32=new Base32();
				String text3=df.getTf3().getText();
				byte[] b_32=text3.getBytes();
				b_32=base32.decode(b_32);
				String text1=new String(b_32);
				df.getTf1().setText(text1);
				}catch(Exception e1){
					throw new RuntimeException("base32解密失败，请重试");
				}
			}
			
		});
		
		//base16解密
		df.getBut4().addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				String text4=df.getTf4().getText();
				MiscDecode md=new MiscDecode(text4);
				byte[] b_16;
				try {
					b_16 = md.decode();
				} catch (Exception e1) {
					throw new RuntimeException("base16解码失败");
				}
				String text1=new String(b_16);
				df.getTf1().setText(text1);
			}
			
		});
		//Hex解密
		df.getBut5().addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				try{
					String text5=df.getTf5().getText();
					byte[] hex=Hex.decodeHex(text5.toCharArray());
					String text1=new String(hex);
					df.getTf1().setText(text1);
				}catch(Exception e1){
					throw new RuntimeException("16进制解码失败");
				}
			}
			
		});
		//url解码
		df.getBut8().addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				String text8=df.getTf8().getText();
				URLCodec urlcode=new URLCodec();
				
					String urlencodes;
					try {
						urlencodes = urlcode.decode(text8);
						df.getTf1().setText(urlencodes);
					} catch (DecoderException e1) {
						throw new RuntimeException("解码失败");
					}
					
				
			}
			
		});
	}


	public static void main(String[] args) {
		new BaseFamily();
	}

}
