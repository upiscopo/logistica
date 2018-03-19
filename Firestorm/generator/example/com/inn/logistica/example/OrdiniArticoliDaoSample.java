/*
 * This source file was generated by FireStorm/DAO.
 * 
 * If you purchase a full license for FireStorm/DAO you can customize this header file.
 * 
 * For more information please visit http://www.codefutures.com/products/firestorm
 */

package com.inn.logistica.example;

import java.math.*;
import java.util.Date;
import java.util.Collection;
import com.inn.logistica.dao.OrdiniArticoliDao;
import com.inn.logistica.dto.OrdiniArticoli;
import com.inn.logistica.exceptions.OrdiniArticoliDaoException;
import com.inn.logistica.factory.OrdiniArticoliDaoFactory;

public class OrdiniArticoliDaoSample
{
	/**
	 * Method 'main'
	 * 
	 * @param arg
	 * @throws Exception
	 */
	public static void main(String[] arg) throws Exception
	{
		// Uncomment one of the lines below to test the generated code
		
		// findAll();
		// findByArticolo(0);
		// findByOrdini(0);
		// findWhereOdeIdEquals(0);
		// findWhereOdeQtaEquals(0);
		// findWhereOrdiniOrdIdEquals(0);
		// findWhereArticoloArtIdEquals(0);
	}

	/**
	 * Method 'findAll'
	 * 
	 */
	public static void findAll()
	{
		try {
			OrdiniArticoliDao _dao = getOrdiniArticoliDao();
			OrdiniArticoli _result[] = _dao.findAll();
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findByArticolo'
	 * 
	 * @param articoloArtId
	 */
	public static void findByArticolo(long articoloArtId)
	{
		try {
			OrdiniArticoliDao _dao = getOrdiniArticoliDao();
			OrdiniArticoli _result[] = _dao.findByArticolo(articoloArtId);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findByOrdini'
	 * 
	 * @param ordiniOrdId
	 */
	public static void findByOrdini(long ordiniOrdId)
	{
		try {
			OrdiniArticoliDao _dao = getOrdiniArticoliDao();
			OrdiniArticoli _result[] = _dao.findByOrdini(ordiniOrdId);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWhereOdeIdEquals'
	 * 
	 * @param odeId
	 */
	public static void findWhereOdeIdEquals(long odeId)
	{
		try {
			OrdiniArticoliDao _dao = getOrdiniArticoliDao();
			OrdiniArticoli _result[] = _dao.findWhereOdeIdEquals(odeId);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWhereOdeQtaEquals'
	 * 
	 * @param odeQta
	 */
	public static void findWhereOdeQtaEquals(int odeQta)
	{
		try {
			OrdiniArticoliDao _dao = getOrdiniArticoliDao();
			OrdiniArticoli _result[] = _dao.findWhereOdeQtaEquals(odeQta);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWhereOrdiniOrdIdEquals'
	 * 
	 * @param ordiniOrdId
	 */
	public static void findWhereOrdiniOrdIdEquals(long ordiniOrdId)
	{
		try {
			OrdiniArticoliDao _dao = getOrdiniArticoliDao();
			OrdiniArticoli _result[] = _dao.findWhereOrdiniOrdIdEquals(ordiniOrdId);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWhereArticoloArtIdEquals'
	 * 
	 * @param articoloArtId
	 */
	public static void findWhereArticoloArtIdEquals(long articoloArtId)
	{
		try {
			OrdiniArticoliDao _dao = getOrdiniArticoliDao();
			OrdiniArticoli _result[] = _dao.findWhereArticoloArtIdEquals(articoloArtId);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'getOrdiniArticoliDao'
	 * 
	 * @return OrdiniArticoliDao
	 */
	public static OrdiniArticoliDao getOrdiniArticoliDao()
	{
		return OrdiniArticoliDaoFactory.create();
	}

	/**
	 * Method 'display'
	 * 
	 * @param dto
	 */
	public static void display(OrdiniArticoli dto)
	{
		StringBuffer buf = new StringBuffer();
		buf.append( dto.getOdeId() );
		buf.append( ", " );
		buf.append( dto.getOdeQta() );
		buf.append( ", " );
		buf.append( dto.getOrdiniOrdId() );
		buf.append( ", " );
		buf.append( dto.getArticoloArtId() );
		System.out.println( buf.toString() );
	}

}
