package com.viewnext.apiusuarios.model;

import javax.persistence.Column;

public class GenericPK<ID1, ID2> {

	private ID1 id1;
	private ID2 id2;
	
	public GenericPK() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GenericPK(ID1 id1, ID2 id2) {
		super();
		this.id1 = id1;
		this.id2 = id2;
	}

	public ID1 getId1() {
		return id1;
	}

	public void setId1(ID1 id1) {
		this.id1 = id1;
	}

	public ID2 getId2() {
		return id2;
	}

	public void setId2(ID2 id2) {
		this.id2 = id2;
	}
	
	
}
