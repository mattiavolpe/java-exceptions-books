package org.java.book;

public class Libro {
	private String titolo;
	private int pagine;
	private String autore;
	private String editore;
	
	public Libro(String titolo, int pagine, String autore, String editore) throws Exception {
		setTitolo(titolo);
		setPagine(pagine);
		setAutore(autore);
		setEditore(editore);
	}
	
	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) throws Exception {
		if (!titolo.isBlank())
			this.titolo = titolo;
		else
			throw new Exception("Title can't be empty");
	}

	public int getPagine() {
		return pagine;
	}

	public void setPagine(int pagine) throws Exception {
		if (pagine > 0)
			this.pagine = pagine;
		else
			throw new Exception("The number of pages can't be 0 or less");
	}

	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) throws Exception {
		if (!autore.isBlank())
			this.autore = autore;
		else
			throw new Exception("Author can't be empty");
	}

	public String getEditore() {
		return editore;
	}

	public void setEditore(String editore) throws Exception {
		if (!editore.isBlank())
			this.editore = editore;
		else
			throw new Exception("Editor can't be empty");
	}
}
