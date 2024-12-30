package tw.brad.stest5.model;

import java.io.IOException;
import java.util.Base64;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

@Entity
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String account;
	private String passwd;
	private String realname;
	
	// 對應資料表
	@JsonIgnore
	private byte[] icon;
	
	// 對應表單
	@Transient
	private MultipartFile iconFile;
	
	// 處理顯示的畫面
	@Transient
	private String iconBase64;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public byte[] getIcon() {
		return icon;
	}
	public void setIcon(byte[] icon) {
		this.icon = icon;
	}
	public MultipartFile getIconFile() {
		return iconFile;
	}
	public void setIconFile(MultipartFile iconFile) {
		System.out.println("上傳檔案...");
		this.iconFile = iconFile;
		try {
			icon = iconFile.getBytes(); // 給 orm 使用來存 blob
		} catch (IOException e) {
			System.out.println(e);
		}	
	}
	public String getIconBase64() {
		return iconBase64;
	}
	public void setIconBase64(String iconBase64) {
		this.iconBase64 = iconBase64;
	}
	
	
	
	
}
