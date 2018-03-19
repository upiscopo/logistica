/*
 * This source file was generated by FireStorm/DAO.
 * 
 * If you purchase a full license for FireStorm/DAO you can customize this header file.
 * 
 * For more information please visit http://www.codefutures.com/products/firestorm
 */

package com.inn.logistica.jdbc;

import com.inn.logistica.dao.*;
import com.inn.logistica.factory.*;
import java.util.Date;
import com.inn.logistica.dto.*;
import com.inn.logistica.exceptions.*;
import java.sql.Connection;
import java.util.Collection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

public class MovimentazioniDaoImpl extends AbstractDAO implements MovimentazioniDao
{
	/** 
	 * The factory class for this DAO has two versions of the create() method - one that
takes no arguments and one that takes a Connection argument. If the Connection version
is chosen then the connection will be stored in this attribute and will be used by all
calls to this DAO, otherwise a new Connection will be allocated for each operation.
	 */
	protected java.sql.Connection userConn;

	/** 
	 * All finder methods in this class use this SELECT constant to build their queries
	 */
	protected final String SQL_SELECT = "SELECT mov_id, mov_data, mov_ora, mov_tipo, anagrafica_ana_id FROM " + getTableName() + "";

	/** 
	 * Finder methods will pass this value to the JDBC setMaxRows method
	 */
	protected int maxRows;

	/** 
	 * SQL INSERT statement for this table
	 */
	protected final String SQL_INSERT = "INSERT INTO " + getTableName() + " ( mov_id, mov_data, mov_ora, mov_tipo, anagrafica_ana_id ) VALUES ( ?, ?, ?, ?, ? )";

	/** 
	 * SQL UPDATE statement for this table
	 */
	protected final String SQL_UPDATE = "UPDATE " + getTableName() + " SET mov_id = ?, mov_data = ?, mov_ora = ?, mov_tipo = ?, anagrafica_ana_id = ? WHERE mov_id = ?";

	/** 
	 * SQL DELETE statement for this table
	 */
	protected final String SQL_DELETE = "DELETE FROM " + getTableName() + " WHERE mov_id = ?";

	/** 
	 * Index of column mov_id
	 */
	protected static final int COLUMN_MOV_ID = 1;

	/** 
	 * Index of column mov_data
	 */
	protected static final int COLUMN_MOV_DATA = 2;

	/** 
	 * Index of column mov_ora
	 */
	protected static final int COLUMN_MOV_ORA = 3;

	/** 
	 * Index of column mov_tipo
	 */
	protected static final int COLUMN_MOV_TIPO = 4;

	/** 
	 * Index of column anagrafica_ana_id
	 */
	protected static final int COLUMN_ANAGRAFICA_ANA_ID = 5;

	/** 
	 * Number of columns
	 */
	protected static final int NUMBER_OF_COLUMNS = 5;

	/** 
	 * Index of primary-key column mov_id
	 */
	protected static final int PK_COLUMN_MOV_ID = 1;

	/** 
	 * Inserts a new row in the movimentazioni table.
	 */
	public MovimentazioniPk insert(Movimentazioni dto) throws MovimentazioniDaoException
	{
		long t1 = System.currentTimeMillis();
		// declare variables
		final boolean isConnSupplied = (userConn != null);
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			// get the user-specified connection or get a connection from the ResourceManager
			conn = isConnSupplied ? userConn : ResourceManager.getConnection();
		
			stmt = conn.prepareStatement( SQL_INSERT );
			int index = 1;
			stmt.setLong( index++, dto.getMovId() );
			stmt.setDate(index++, dto.getMovData()==null ? null : new java.sql.Date( dto.getMovData().getTime() ) );
			stmt.setString( index++, dto.getMovOra() );
			stmt.setString( index++, dto.getMovTipo() );
			if (dto.isAnagraficaAnaIdNull()) {
				stmt.setNull( index++, java.sql.Types.INTEGER );
			} else {
				stmt.setLong( index++, dto.getAnagraficaAnaId() );
			}
		
			System.out.println( "Executing " + SQL_INSERT + " with DTO: " + dto );
			int rows = stmt.executeUpdate();
			long t2 = System.currentTimeMillis();
			System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
			reset(dto);
			return dto.createPk();
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new MovimentazioniDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Updates a single row in the movimentazioni table.
	 */
	public void update(MovimentazioniPk pk, Movimentazioni dto) throws MovimentazioniDaoException
	{
		long t1 = System.currentTimeMillis();
		// declare variables
		final boolean isConnSupplied = (userConn != null);
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			// get the user-specified connection or get a connection from the ResourceManager
			conn = isConnSupplied ? userConn : ResourceManager.getConnection();
		
			System.out.println( "Executing " + SQL_UPDATE + " with DTO: " + dto );
			stmt = conn.prepareStatement( SQL_UPDATE );
			int index=1;
			stmt.setLong( index++, dto.getMovId() );
			stmt.setDate(index++, dto.getMovData()==null ? null : new java.sql.Date( dto.getMovData().getTime() ) );
			stmt.setString( index++, dto.getMovOra() );
			stmt.setString( index++, dto.getMovTipo() );
			if (dto.isAnagraficaAnaIdNull()) {
				stmt.setNull( index++, java.sql.Types.INTEGER );
			} else {
				stmt.setLong( index++, dto.getAnagraficaAnaId() );
			}
		
			stmt.setLong( 6, pk.getMovId() );
			int rows = stmt.executeUpdate();
			reset(dto);
			long t2 = System.currentTimeMillis();
			System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new MovimentazioniDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Deletes a single row in the movimentazioni table.
	 */
	public void delete(MovimentazioniPk pk) throws MovimentazioniDaoException
	{
		long t1 = System.currentTimeMillis();
		// declare variables
		final boolean isConnSupplied = (userConn != null);
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			// get the user-specified connection or get a connection from the ResourceManager
			conn = isConnSupplied ? userConn : ResourceManager.getConnection();
		
			System.out.println( "Executing " + SQL_DELETE + " with PK: " + pk );
			stmt = conn.prepareStatement( SQL_DELETE );
			stmt.setLong( 1, pk.getMovId() );
			int rows = stmt.executeUpdate();
			long t2 = System.currentTimeMillis();
			System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new MovimentazioniDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Returns the rows from the movimentazioni table that matches the specified primary-key value.
	 */
	public Movimentazioni findByPrimaryKey(MovimentazioniPk pk) throws MovimentazioniDaoException
	{
		return findByPrimaryKey( pk.getMovId() );
	}

	/** 
	 * Returns all rows from the movimentazioni table that match the criteria 'mov_id = :movId'.
	 */
	public Movimentazioni findByPrimaryKey(long movId) throws MovimentazioniDaoException
	{
		Movimentazioni ret[] = findByDynamicSelect( SQL_SELECT + " WHERE mov_id = ?", new Object[] {  new Long(movId) } );
		return ret.length==0 ? null : ret[0];
	}

	/** 
	 * Returns all rows from the movimentazioni table that match the criteria ''.
	 */
	public Movimentazioni[] findAll() throws MovimentazioniDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " ORDER BY mov_id", null );
	}

	/** 
	 * Returns all rows from the movimentazioni table that match the criteria 'anagrafica_ana_id = :anagraficaAnaId'.
	 */
	public Movimentazioni[] findByAnagrafica(long anagraficaAnaId) throws MovimentazioniDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE anagrafica_ana_id = ?", new Object[] {  new Long(anagraficaAnaId) } );
	}

	/** 
	 * Returns all rows from the movimentazioni table that match the criteria 'mov_id = :movId'.
	 */
	public Movimentazioni[] findWhereMovIdEquals(long movId) throws MovimentazioniDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE mov_id = ? ORDER BY mov_id", new Object[] {  new Long(movId) } );
	}

	/** 
	 * Returns all rows from the movimentazioni table that match the criteria 'mov_data = :movData'.
	 */
	public Movimentazioni[] findWhereMovDataEquals(Date movData) throws MovimentazioniDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE mov_data = ? ORDER BY mov_data", new Object[] { movData==null ? null : new java.sql.Date( movData.getTime() ) } );
	}

	/** 
	 * Returns all rows from the movimentazioni table that match the criteria 'mov_ora = :movOra'.
	 */
	public Movimentazioni[] findWhereMovOraEquals(String movOra) throws MovimentazioniDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE mov_ora = ? ORDER BY mov_ora", new Object[] { movOra } );
	}

	/** 
	 * Returns all rows from the movimentazioni table that match the criteria 'mov_tipo = :movTipo'.
	 */
	public Movimentazioni[] findWhereMovTipoEquals(String movTipo) throws MovimentazioniDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE mov_tipo = ? ORDER BY mov_tipo", new Object[] { movTipo } );
	}

	/** 
	 * Returns all rows from the movimentazioni table that match the criteria 'anagrafica_ana_id = :anagraficaAnaId'.
	 */
	public Movimentazioni[] findWhereAnagraficaAnaIdEquals(long anagraficaAnaId) throws MovimentazioniDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE anagrafica_ana_id = ? ORDER BY anagrafica_ana_id", new Object[] {  new Long(anagraficaAnaId) } );
	}

	/**
	 * Method 'MovimentazioniDaoImpl'
	 * 
	 */
	public MovimentazioniDaoImpl()
	{
	}

	/**
	 * Method 'MovimentazioniDaoImpl'
	 * 
	 * @param userConn
	 */
	public MovimentazioniDaoImpl(final java.sql.Connection userConn)
	{
		this.userConn = userConn;
	}

	/** 
	 * Sets the value of maxRows
	 */
	public void setMaxRows(int maxRows)
	{
		this.maxRows = maxRows;
	}

	/** 
	 * Gets the value of maxRows
	 */
	public int getMaxRows()
	{
		return maxRows;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "movimentazioni";
	}

	/** 
	 * Fetches a single row from the result set
	 */
	protected Movimentazioni fetchSingleResult(ResultSet rs) throws SQLException
	{
		if (rs.next()) {
			Movimentazioni dto = new Movimentazioni();
			populateDto( dto, rs);
			return dto;
		} else {
			return null;
		}
		
	}

	/** 
	 * Fetches multiple rows from the result set
	 */
	protected Movimentazioni[] fetchMultiResults(ResultSet rs) throws SQLException
	{
		Collection resultList = new ArrayList();
		while (rs.next()) {
			Movimentazioni dto = new Movimentazioni();
			populateDto( dto, rs);
			resultList.add( dto );
		}
		
		Movimentazioni ret[] = new Movimentazioni[ resultList.size() ];
		resultList.toArray( ret );
		return ret;
	}

	/** 
	 * Populates a DTO with data from a ResultSet
	 */
	protected void populateDto(Movimentazioni dto, ResultSet rs) throws SQLException
	{
		dto.setMovId( rs.getLong( COLUMN_MOV_ID ) );
		dto.setMovData( rs.getDate(COLUMN_MOV_DATA ) );
		dto.setMovOra( rs.getString( COLUMN_MOV_ORA ) );
		dto.setMovTipo( rs.getString( COLUMN_MOV_TIPO ) );
		dto.setAnagraficaAnaId( rs.getLong( COLUMN_ANAGRAFICA_ANA_ID ) );
		if (rs.wasNull()) {
			dto.setAnagraficaAnaIdNull( true );
		}
		
	}

	/** 
	 * Resets the modified attributes in the DTO
	 */
	protected void reset(Movimentazioni dto)
	{
	}

	/** 
	 * Returns all rows from the movimentazioni table that match the specified arbitrary SQL statement
	 */
	public Movimentazioni[] findByDynamicSelect(String sql, Object[] sqlParams) throws MovimentazioniDaoException
	{
		// declare variables
		final boolean isConnSupplied = (userConn != null);
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			// get the user-specified connection or get a connection from the ResourceManager
			conn = isConnSupplied ? userConn : ResourceManager.getConnection();
		
			// construct the SQL statement
			final String SQL = sql;
		
		
			System.out.println( "Executing " + SQL );
			// prepare statement
			stmt = conn.prepareStatement( SQL );
			stmt.setMaxRows( maxRows );
		
			// bind parameters
			for (int i=0; sqlParams!=null && i<sqlParams.length; i++ ) {
				stmt.setObject( i+1, sqlParams[i] );
			}
		
		
			rs = stmt.executeQuery();
		
			// fetch the results
			return fetchMultiResults(rs);
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new MovimentazioniDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(rs);
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Returns all rows from the movimentazioni table that match the specified arbitrary SQL statement
	 */
	public Movimentazioni[] findByDynamicWhere(String sql, Object[] sqlParams) throws MovimentazioniDaoException
	{
		// declare variables
		final boolean isConnSupplied = (userConn != null);
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			// get the user-specified connection or get a connection from the ResourceManager
			conn = isConnSupplied ? userConn : ResourceManager.getConnection();
		
			// construct the SQL statement
			final String SQL = SQL_SELECT + " WHERE " + sql;
		
		
			System.out.println( "Executing " + SQL );
			// prepare statement
			stmt = conn.prepareStatement( SQL );
			stmt.setMaxRows( maxRows );
		
			// bind parameters
			for (int i=0; sqlParams!=null && i<sqlParams.length; i++ ) {
				stmt.setObject( i+1, sqlParams[i] );
			}
		
		
			rs = stmt.executeQuery();
		
			// fetch the results
			return fetchMultiResults(rs);
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new MovimentazioniDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(rs);
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

}
