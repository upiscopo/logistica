/*
 * This source file was generated by FireStorm/DAO.
 * 
 * If you purchase a full license for FireStorm/DAO you can customize this header file.
 * 
 * For more information please visit http://www.codefutures.com/products/firestorm
 */

package com.inn.logistica.dto;

import com.inn.logistica.dao.*;
import com.inn.logistica.factory.*;
import com.inn.logistica.exceptions.*;
import java.io.Serializable;
import java.util.*;
import java.util.Date;

public class Articolo implements Serializable
{
	/** 
	 * This attribute maps to the column art_id in the articolo table.
	 */
	protected long artId;

	/** 
	 * This attribute maps to the column art_codice in the articolo table.
	 */
	protected String artCodice;

	/** 
	 * This attribute maps to the column art_descrizione in the articolo table.
	 */
	protected String artDescrizione;

	/** 
	 * This attribute maps to the column art_barcode in the articolo table.
	 */
	protected String artBarcode;

	/** 
	 * This attribute maps to the column art_giacenza in the articolo table.
	 */
	protected int artGiacenza;

	/** 
	 * This attribute represents whether the primitive attribute artGiacenza is null.
	 */
	protected boolean artGiacenzaNull = true;

	/** 
	 * This attribute maps to the column art_agg_dt in the articolo table.
	 */
	protected Date artAggDt;

	/**
	 * Method 'Articolo'
	 * 
	 */
	public Articolo()
	{
	}

	/**
	 * Method 'getArtId'
	 * 
	 * @return long
	 */
	public long getArtId()
	{
		return artId;
	}

	/**
	 * Method 'setArtId'
	 * 
	 * @param artId
	 */
	public void setArtId(long artId)
	{
		this.artId = artId;
	}

	/**
	 * Method 'getArtCodice'
	 * 
	 * @return String
	 */
	public String getArtCodice()
	{
		return artCodice;
	}

	/**
	 * Method 'setArtCodice'
	 * 
	 * @param artCodice
	 */
	public void setArtCodice(String artCodice)
	{
		this.artCodice = artCodice;
	}

	/**
	 * Method 'getArtDescrizione'
	 * 
	 * @return String
	 */
	public String getArtDescrizione()
	{
		return artDescrizione;
	}

	/**
	 * Method 'setArtDescrizione'
	 * 
	 * @param artDescrizione
	 */
	public void setArtDescrizione(String artDescrizione)
	{
		this.artDescrizione = artDescrizione;
	}

	/**
	 * Method 'getArtBarcode'
	 * 
	 * @return String
	 */
	public String getArtBarcode()
	{
		return artBarcode;
	}

	/**
	 * Method 'setArtBarcode'
	 * 
	 * @param artBarcode
	 */
	public void setArtBarcode(String artBarcode)
	{
		this.artBarcode = artBarcode;
	}

	/**
	 * Method 'getArtGiacenza'
	 * 
	 * @return int
	 */
	public int getArtGiacenza()
	{
		return artGiacenza;
	}

	/**
	 * Method 'setArtGiacenza'
	 * 
	 * @param artGiacenza
	 */
	public void setArtGiacenza(int artGiacenza)
	{
		this.artGiacenza = artGiacenza;
		this.artGiacenzaNull = false;
	}

	/**
	 * Method 'setArtGiacenzaNull'
	 * 
	 * @param value
	 */
	public void setArtGiacenzaNull(boolean value)
	{
		this.artGiacenzaNull = value;
	}

	/**
	 * Method 'isArtGiacenzaNull'
	 * 
	 * @return boolean
	 */
	public boolean isArtGiacenzaNull()
	{
		return artGiacenzaNull;
	}

	/**
	 * Method 'getArtAggDt'
	 * 
	 * @return Date
	 */
	public Date getArtAggDt()
	{
		return artAggDt;
	}

	/**
	 * Method 'setArtAggDt'
	 * 
	 * @param artAggDt
	 */
	public void setArtAggDt(Date artAggDt)
	{
		this.artAggDt = artAggDt;
	}

	/**
	 * Method 'equals'
	 * 
	 * @param _other
	 * @return boolean
	 */
	public boolean equals(Object _other)
	{
		if (_other == null) {
			return false;
		}
		
		if (_other == this) {
			return true;
		}
		
		if (!(_other instanceof Articolo)) {
			return false;
		}
		
		final Articolo _cast = (Articolo) _other;
		if (artId != _cast.artId) {
			return false;
		}
		
		if (artCodice == null ? _cast.artCodice != artCodice : !artCodice.equals( _cast.artCodice )) {
			return false;
		}
		
		if (artDescrizione == null ? _cast.artDescrizione != artDescrizione : !artDescrizione.equals( _cast.artDescrizione )) {
			return false;
		}
		
		if (artBarcode == null ? _cast.artBarcode != artBarcode : !artBarcode.equals( _cast.artBarcode )) {
			return false;
		}
		
		if (artGiacenza != _cast.artGiacenza) {
			return false;
		}
		
		if (artGiacenzaNull != _cast.artGiacenzaNull) {
			return false;
		}
		
		if (artAggDt == null ? _cast.artAggDt != artAggDt : !artAggDt.equals( _cast.artAggDt )) {
			return false;
		}
		
		return true;
	}

	/**
	 * Method 'hashCode'
	 * 
	 * @return int
	 */
	public int hashCode()
	{
		int _hashCode = 0;
		_hashCode = 29 * _hashCode + (int) (artId ^ (artId >>> 32));
		if (artCodice != null) {
			_hashCode = 29 * _hashCode + artCodice.hashCode();
		}
		
		if (artDescrizione != null) {
			_hashCode = 29 * _hashCode + artDescrizione.hashCode();
		}
		
		if (artBarcode != null) {
			_hashCode = 29 * _hashCode + artBarcode.hashCode();
		}
		
		_hashCode = 29 * _hashCode + artGiacenza;
		_hashCode = 29 * _hashCode + (artGiacenzaNull ? 1 : 0);
		if (artAggDt != null) {
			_hashCode = 29 * _hashCode + artAggDt.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return ArticoloPk
	 */
	public ArticoloPk createPk()
	{
		return new ArticoloPk(artId);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "com.inn.logistica.dto.Articolo: " );
		ret.append( "artId=" + artId );
		ret.append( ", artCodice=" + artCodice );
		ret.append( ", artDescrizione=" + artDescrizione );
		ret.append( ", artBarcode=" + artBarcode );
		ret.append( ", artGiacenza=" + artGiacenza );
		ret.append( ", artAggDt=" + artAggDt );
		return ret.toString();
	}

}
