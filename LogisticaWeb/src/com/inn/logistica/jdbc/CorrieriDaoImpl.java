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

public class CorrieriDaoImpl extends AbstractDAO implements CorrieriDao
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
	protected final String SQL_SELECT = "SELECT cor_id, cor_nominativo, cor_url_tracking, cor_abil_tracking FROM " + getTableName() + "";

	/** 
	 * Finder methods will pass this value to the JDBC setMaxRows method
	 */
	protected int maxRows;

	/** 
	 * SQL INSERT statement for this table
	 */
	protected final String SQL_INSERT = "INSERT INTO " + getTableName() + " ( cor_id, cor_nominativo, cor_url_tracking, cor_abil_tracking ) VALUES ( ?, ?, ?, ? )";

	/** 
	 * SQL UPDATE statement for this table
	 */
	protected final String SQL_UPDATE = "UPDATE " + getTableName() + " SET cor_id = ?, cor_nominativo = ?, cor_url_tracking = ?, cor_abil_tracking = ? WHERE cor_id = ?";

	/** 
	 * SQL DELETE statement for this table
	 */
	protected final String SQL_DELETE = "DELETE FROM " + getTableName() + " WHERE cor_id = ?";

	/** 
	 * Index of column cor_id
	 */
	protected static final int COLUMN_COR_ID = 1;

	/** 
	 * Index of column cor_nominativo
	 */
	protected static final int COLUMN_COR_NOMINATIVO = 2;

	/** 
	 * Index of column cor_url_tracking
	 */
	protected static final int COLUMN_COR_URL_TRACKING = 3;

	/** 
	 * Index of column cor_abil_tracking
	 */
	protected static final int COLUMN_COR_ABIL_TRACKING = 4;

	/** 
	 * Number of columns
	 */
	protected static final int NUMBER_OF_COLUMNS = 4;

	/** 
	 * Index of primary-key column cor_id
	 */
	protected static final int PK_COLUMN_COR_ID = 1;

	/** 
	 * Inserts a new row in the corrieri table.
	 */
	public CorrieriPk insert(Corrieri dto) throws CorrieriDaoException
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
		
			stmt = conn.prepareStatement( "SELECT nextval('seq_anagrafiche')" );
			rs = stmt.executeQuery();
			if (rs.next()) {
				dto.setCorId( rs.getLong( 1 ) );
				rs.close();
				stmt.close();
			}
		
			stmt = conn.prepareStatement( SQL_INSERT );
			int index = 1;
			stmt.setLong( index++, dto.getCorId() );
			stmt.setString( index++, dto.getCorNominativo() );
			stmt.setString( index++, dto.getCorUrlTracking() );
			stmt.setInt( index++, dto.getCorAbilTracking() );
			System.out.println( "Executing " + SQL_INSERT + " with DTO: " + dto );
			int rows = stmt.executeUpdate();
			long t2 = System.currentTimeMillis();
			System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
			reset(dto);
			return dto.createPk();
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new CorrieriDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Updates a single row in the corrieri table.
	 */
	public void update(CorrieriPk pk, Corrieri dto) throws CorrieriDaoException
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
			stmt.setLong( index++, dto.getCorId() );
			stmt.setString( index++, dto.getCorNominativo() );
			stmt.setString( index++, dto.getCorUrlTracking() );
			stmt.setInt( index++, dto.getCorAbilTracking() );
			stmt.setLong( 5, pk.getCorId() );
			int rows = stmt.executeUpdate();
			reset(dto);
			long t2 = System.currentTimeMillis();
			System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new CorrieriDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Deletes a single row in the corrieri table.
	 */
	public void delete(CorrieriPk pk) throws CorrieriDaoException
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
			stmt.setLong( 1, pk.getCorId() );
			int rows = stmt.executeUpdate();
			long t2 = System.currentTimeMillis();
			System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new CorrieriDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Returns the rows from the corrieri table that matches the specified primary-key value.
	 */
	public Corrieri findByPrimaryKey(CorrieriPk pk) throws CorrieriDaoException
	{
		return findByPrimaryKey( pk.getCorId() );
	}

	/** 
	 * Returns all rows from the corrieri table that match the criteria 'cor_id = :corId'.
	 */
	public Corrieri findByPrimaryKey(long corId) throws CorrieriDaoException
	{
		Corrieri ret[] = findByDynamicSelect( SQL_SELECT + " WHERE cor_id = ?", new Object[] {  new Long(corId) } );
		return ret.length==0 ? null : ret[0];
	}

	/** 
	 * Returns all rows from the corrieri table that match the criteria ''.
	 */
	public Corrieri[] findAll() throws CorrieriDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " ORDER BY cor_id", null );
	}

	/** 
	 * Returns all rows from the corrieri table that match the criteria 'cor_id = :corId'.
	 */
	public Corrieri[] findWhereCorIdEquals(long corId) throws CorrieriDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE cor_id = ? ORDER BY cor_id", new Object[] {  new Long(corId) } );
	}

	/** 
	 * Returns all rows from the corrieri table that match the criteria 'cor_nominativo = :corNominativo'.
	 */
	public Corrieri[] findWhereCorNominativoEquals(String corNominativo) throws CorrieriDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE cor_nominativo = ? ORDER BY cor_nominativo", new Object[] { corNominativo } );
	}

	/** 
	 * Returns all rows from the corrieri table that match the criteria 'cor_url_tracking = :corUrlTracking'.
	 */
	public Corrieri[] findWhereCorUrlTrackingEquals(String corUrlTracking) throws CorrieriDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE cor_url_tracking = ? ORDER BY cor_url_tracking", new Object[] { corUrlTracking } );
	}

	/** 
	 * Returns all rows from the corrieri table that match the criteria 'cor_abil_tracking = :corAbilTracking'.
	 */
	public Corrieri[] findWhereCorAbilTrackingEquals(int corAbilTracking) throws CorrieriDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE cor_abil_tracking = ? ORDER BY cor_abil_tracking", new Object[] {  new Integer(corAbilTracking) } );
	}

	/**
	 * Method 'CorrieriDaoImpl'
	 * 
	 */
	public CorrieriDaoImpl()
	{
	}

	/**
	 * Method 'CorrieriDaoImpl'
	 * 
	 * @param userConn
	 */
	public CorrieriDaoImpl(final java.sql.Connection userConn)
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
		return "corrieri";
	}

	/** 
	 * Fetches a single row from the result set
	 */
	protected Corrieri fetchSingleResult(ResultSet rs) throws SQLException
	{
		if (rs.next()) {
			Corrieri dto = new Corrieri();
			populateDto( dto, rs);
			return dto;
		} else {
			return null;
		}
		
	}

	/** 
	 * Fetches multiple rows from the result set
	 */
	protected Corrieri[] fetchMultiResults(ResultSet rs) throws SQLException
	{
		Collection resultList = new ArrayList();
		while (rs.next()) {
			Corrieri dto = new Corrieri();
			populateDto( dto, rs);
			resultList.add( dto );
		}
		
		Corrieri ret[] = new Corrieri[ resultList.size() ];
		resultList.toArray( ret );
		return ret;
	}

	/** 
	 * Populates a DTO with data from a ResultSet
	 */
	protected void populateDto(Corrieri dto, ResultSet rs) throws SQLException
	{
		dto.setCorId( rs.getLong( COLUMN_COR_ID ) );
		dto.setCorNominativo( rs.getString( COLUMN_COR_NOMINATIVO ) );
		dto.setCorUrlTracking( rs.getString( COLUMN_COR_URL_TRACKING ) );
		dto.setCorAbilTracking( rs.getInt( COLUMN_COR_ABIL_TRACKING ) );
	}

	/** 
	 * Resets the modified attributes in the DTO
	 */
	protected void reset(Corrieri dto)
	{
	}

	/** 
	 * Returns all rows from the corrieri table that match the specified arbitrary SQL statement
	 */
	public Corrieri[] findByDynamicSelect(String sql, Object[] sqlParams) throws CorrieriDaoException
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
			throw new CorrieriDaoException( "Exception: " + _e.getMessage(), _e );
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
	 * Returns all rows from the corrieri table that match the specified arbitrary SQL statement
	 */
	public Corrieri[] findByDynamicWhere(String sql, Object[] sqlParams) throws CorrieriDaoException
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
			throw new CorrieriDaoException( "Exception: " + _e.getMessage(), _e );
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
