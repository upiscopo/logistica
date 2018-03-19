/*
 * This source file was generated by FireStorm/DAO.
 * 
 * If you purchase a full license for FireStorm/DAO you can customize this header file.
 * 
 * For more information please visit http://www.codefutures.com/products/firestorm
 */

package com.inn.logistica.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/** 
 * This class represents the primary key of the ordini table.
 */
public class OrdiniPk implements Serializable
{
	protected long ordId;

	/** 
	 * This attribute represents whether the primitive attribute ordId is null.
	 */
	protected boolean ordIdNull;

	/** 
	 * Sets the value of ordId
	 */
	public void setOrdId(long ordId)
	{
		this.ordId = ordId;
	}

	/** 
	 * Gets the value of ordId
	 */
	public long getOrdId()
	{
		return ordId;
	}

	/**
	 * Method 'OrdiniPk'
	 * 
	 */
	public OrdiniPk()
	{
	}

	/**
	 * Method 'OrdiniPk'
	 * 
	 * @param ordId
	 */
	public OrdiniPk(final long ordId)
	{
		this.ordId = ordId;
	}

	/** 
	 * Sets the value of ordIdNull
	 */
	public void setOrdIdNull(boolean ordIdNull)
	{
		this.ordIdNull = ordIdNull;
	}

	/** 
	 * Gets the value of ordIdNull
	 */
	public boolean isOrdIdNull()
	{
		return ordIdNull;
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
		
		if (!(_other instanceof OrdiniPk)) {
			return false;
		}
		
		final OrdiniPk _cast = (OrdiniPk) _other;
		if (ordId != _cast.ordId) {
			return false;
		}
		
		if (ordIdNull != _cast.ordIdNull) {
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
		_hashCode = 29 * _hashCode + (int) (ordId ^ (ordId >>> 32));
		_hashCode = 29 * _hashCode + (ordIdNull ? 1 : 0);
		return _hashCode;
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "com.inn.logistica.dto.OrdiniPk: " );
		ret.append( "ordId=" + ordId );
		return ret.toString();
	}

}
