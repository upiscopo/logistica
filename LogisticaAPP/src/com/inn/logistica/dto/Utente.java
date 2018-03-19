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

public class Utente implements Serializable
{
	/** 
	 * This attribute maps to the column ute_id in the utente table.
	 */
	protected long uteId;

	/** 
	 * This attribute maps to the column ute_nominativo in the utente table.
	 */
	protected String uteNominativo;

	/** 
	 * This attribute maps to the column ute_email in the utente table.
	 */
	protected String uteEmail;

	/** 
	 * This attribute maps to the column ute_password in the utente table.
	 */
	protected String utePassword;

	/** 
	 * This attribute maps to the column ute_cf_piva in the utente table.
	 */
	protected String uteCfPiva;

	/** 
	 * This attribute maps to the column ute_profilo in the utente table.
	 */
	protected String uteProfilo;

	/** 
	 * This attribute maps to the column ute_stato in the utente table.
	 */
	protected String uteStato;

	/** 
	 * This attribute maps to the column ute_last_login in the utente table.
	 */
	protected Date uteLastLogin;

	/** 
	 * This attribute maps to the column ute_tentativi in the utente table.
	 */
	protected int uteTentativi;

	/** 
	 * This attribute represents whether the primitive attribute uteTentativi is null.
	 */
	protected boolean uteTentativiNull = true;

	/**
	 * Method 'Utente'
	 * 
	 */
	public Utente()
	{
	}

	/**
	 * Method 'getUteId'
	 * 
	 * @return long
	 */
	public long getUteId()
	{
		return uteId;
	}

	/**
	 * Method 'setUteId'
	 * 
	 * @param uteId
	 */
	public void setUteId(long uteId)
	{
		this.uteId = uteId;
	}

	/**
	 * Method 'getUteNominativo'
	 * 
	 * @return String
	 */
	public String getUteNominativo()
	{
		return uteNominativo;
	}

	/**
	 * Method 'setUteNominativo'
	 * 
	 * @param uteNominativo
	 */
	public void setUteNominativo(String uteNominativo)
	{
		this.uteNominativo = uteNominativo;
	}

	/**
	 * Method 'getUteEmail'
	 * 
	 * @return String
	 */
	public String getUteEmail()
	{
		return uteEmail;
	}

	/**
	 * Method 'setUteEmail'
	 * 
	 * @param uteEmail
	 */
	public void setUteEmail(String uteEmail)
	{
		this.uteEmail = uteEmail;
	}

	/**
	 * Method 'getUtePassword'
	 * 
	 * @return String
	 */
	public String getUtePassword()
	{
		return utePassword;
	}

	/**
	 * Method 'setUtePassword'
	 * 
	 * @param utePassword
	 */
	public void setUtePassword(String utePassword)
	{
		this.utePassword = utePassword;
	}

	/**
	 * Method 'getUteCfPiva'
	 * 
	 * @return String
	 */
	public String getUteCfPiva()
	{
		return uteCfPiva;
	}

	/**
	 * Method 'setUteCfPiva'
	 * 
	 * @param uteCfPiva
	 */
	public void setUteCfPiva(String uteCfPiva)
	{
		this.uteCfPiva = uteCfPiva;
	}

	/**
	 * Method 'getUteProfilo'
	 * 
	 * @return String
	 */
	public String getUteProfilo()
	{
		return uteProfilo;
	}

	/**
	 * Method 'setUteProfilo'
	 * 
	 * @param uteProfilo
	 */
	public void setUteProfilo(String uteProfilo)
	{
		this.uteProfilo = uteProfilo;
	}

	/**
	 * Method 'getUteStato'
	 * 
	 * @return String
	 */
	public String getUteStato()
	{
		return uteStato;
	}

	/**
	 * Method 'setUteStato'
	 * 
	 * @param uteStato
	 */
	public void setUteStato(String uteStato)
	{
		this.uteStato = uteStato;
	}

	/**
	 * Method 'getUteLastLogin'
	 * 
	 * @return Date
	 */
	public Date getUteLastLogin()
	{
		return uteLastLogin;
	}

	/**
	 * Method 'setUteLastLogin'
	 * 
	 * @param uteLastLogin
	 */
	public void setUteLastLogin(Date uteLastLogin)
	{
		this.uteLastLogin = uteLastLogin;
	}

	/**
	 * Method 'getUteTentativi'
	 * 
	 * @return int
	 */
	public int getUteTentativi()
	{
		return uteTentativi;
	}

	/**
	 * Method 'setUteTentativi'
	 * 
	 * @param uteTentativi
	 */
	public void setUteTentativi(int uteTentativi)
	{
		this.uteTentativi = uteTentativi;
		this.uteTentativiNull = false;
	}

	/**
	 * Method 'setUteTentativiNull'
	 * 
	 * @param value
	 */
	public void setUteTentativiNull(boolean value)
	{
		this.uteTentativiNull = value;
	}

	/**
	 * Method 'isUteTentativiNull'
	 * 
	 * @return boolean
	 */
	public boolean isUteTentativiNull()
	{
		return uteTentativiNull;
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
		
		if (!(_other instanceof Utente)) {
			return false;
		}
		
		final Utente _cast = (Utente) _other;
		if (uteId != _cast.uteId) {
			return false;
		}
		
		if (uteNominativo == null ? _cast.uteNominativo != uteNominativo : !uteNominativo.equals( _cast.uteNominativo )) {
			return false;
		}
		
		if (uteEmail == null ? _cast.uteEmail != uteEmail : !uteEmail.equals( _cast.uteEmail )) {
			return false;
		}
		
		if (utePassword == null ? _cast.utePassword != utePassword : !utePassword.equals( _cast.utePassword )) {
			return false;
		}
		
		if (uteCfPiva == null ? _cast.uteCfPiva != uteCfPiva : !uteCfPiva.equals( _cast.uteCfPiva )) {
			return false;
		}
		
		if (uteProfilo == null ? _cast.uteProfilo != uteProfilo : !uteProfilo.equals( _cast.uteProfilo )) {
			return false;
		}
		
		if (uteStato == null ? _cast.uteStato != uteStato : !uteStato.equals( _cast.uteStato )) {
			return false;
		}
		
		if (uteLastLogin == null ? _cast.uteLastLogin != uteLastLogin : !uteLastLogin.equals( _cast.uteLastLogin )) {
			return false;
		}
		
		if (uteTentativi != _cast.uteTentativi) {
			return false;
		}
		
		if (uteTentativiNull != _cast.uteTentativiNull) {
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
		_hashCode = 29 * _hashCode + (int) (uteId ^ (uteId >>> 32));
		if (uteNominativo != null) {
			_hashCode = 29 * _hashCode + uteNominativo.hashCode();
		}
		
		if (uteEmail != null) {
			_hashCode = 29 * _hashCode + uteEmail.hashCode();
		}
		
		if (utePassword != null) {
			_hashCode = 29 * _hashCode + utePassword.hashCode();
		}
		
		if (uteCfPiva != null) {
			_hashCode = 29 * _hashCode + uteCfPiva.hashCode();
		}
		
		if (uteProfilo != null) {
			_hashCode = 29 * _hashCode + uteProfilo.hashCode();
		}
		
		if (uteStato != null) {
			_hashCode = 29 * _hashCode + uteStato.hashCode();
		}
		
		if (uteLastLogin != null) {
			_hashCode = 29 * _hashCode + uteLastLogin.hashCode();
		}
		
		_hashCode = 29 * _hashCode + uteTentativi;
		_hashCode = 29 * _hashCode + (uteTentativiNull ? 1 : 0);
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return UtentePk
	 */
	public UtentePk createPk()
	{
		return new UtentePk(uteId);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "com.inn.logistica.dto.Utente: " );
		ret.append( "uteId=" + uteId );
		ret.append( ", uteNominativo=" + uteNominativo );
		ret.append( ", uteEmail=" + uteEmail );
		ret.append( ", utePassword=" + utePassword );
		ret.append( ", uteCfPiva=" + uteCfPiva );
		ret.append( ", uteProfilo=" + uteProfilo );
		ret.append( ", uteStato=" + uteStato );
		ret.append( ", uteLastLogin=" + uteLastLogin );
		ret.append( ", uteTentativi=" + uteTentativi );
		return ret.toString();
	}

}
