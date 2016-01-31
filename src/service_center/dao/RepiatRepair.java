package service_center.dao;

import java.util.*;
import javax.persistence.*;

@Entity
public class RepiatRepair {
	@Id
	@GeneratedValue
	private int id;
	private Date date;
	private String defectCorrect;
//	private Map<Integer, String> status;
	private String authorizedService;
	private Date dateTransfer;
	private String infoTransfer;
	
	public RepiatRepair() {
		super();
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

		public String getDefectCorrect() {
		return defectCorrect;
	}

	public void setDefectCorrect(String defectCorrect) {
		this.defectCorrect = defectCorrect;
	}

/*	public Map<Integer, String> getStatus() {
		return status;
	}

	public void setStatus(Map<Integer, String> status) {
		this.status = status;
	}
*/
	public String getAuthorizedService() {
		return authorizedService;
	}

	public void setAuthorizedService(String authorizedService) {
		this.authorizedService = authorizedService;
	}

	public Date getDateTransfer() {
		return dateTransfer;
	}

	public void setDateTransfer(Date dateTransfer) {
		this.dateTransfer = dateTransfer;
	}

	public String getInfoTransfer() {
		return infoTransfer;
	}

	public void setInfoTransfer(String infoTransfer) {
		this.infoTransfer = infoTransfer;
	}
}
