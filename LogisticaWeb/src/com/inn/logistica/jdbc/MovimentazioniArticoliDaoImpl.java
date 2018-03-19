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

public class MovimentazioniArticoliDaoImpl extends AbstractDAO implements MovimentazioniArticoliDao
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
	protected final String SQL_SELECT = "SELECT mvd_id, mvd_qta, articolo_art_id, movimentazioni_mov_id FROM " + getTableName() + "";

	/** 
	 * Finder methods will pass this value to the JDBC setMaxRows method
	 */
	protected int maxRows;

	/** 
	 * SQL INSERT statement for this table
	 */
	protected final String SQL_INSERT = "INSERT INTO " + getTableName() + " ( mvd_id, mvd_qta, articolo_art_id, movimentazioni_mov_id ) VALUES ( ?, ?, ?, ? )";

	/** 
	 * SQL UPDATE statement for this table
	 */
	protected final String SQL_UPDATE = "UPDATE " + getTableName() + " SET mvd_id = ?, mvd_qta = ?, articolo_art_id = ?, movimentazioni_mov_id = ? WHERE mvd_id = ?";

	/** 
	 * SQL DELETE statement for this table
	 */
	protected final String SQL_DELETE = "DELETE FROM " + getTableName() + " WHERE mvd_id = ?";

	/** 
	 * Index of column mvd_id
	 */
	protected static final int COLUMN_MVD_ID = 1;

	/** 
	 * Index of column mvd_qta
	 */
	protected static final int COLUMN_MVD_QTA = 2;

	/** 
	 * Index of column articolo_art_id
	 */
	protected static final int COLUMN_ARTICOLO_ART_ID = 3;

	/** 
	 * Index of column movimentazioni_mov_id
	 */
	protected static final int COLUMN_MOVIMENTAZIONI_MOV_ID = 4;

	/** 
	 * Number of columns
	 */
	protected static final int NUMBER_OF_COLUMNS = 4;

	/** 
	 * Index of primary-key column mvd_id
	 */
	protected static final int PK_COLUMN_MVD_ID = 1;

	/** 
	 * Inserts a new row in the movimentazioni_articoli table.
	 */
	public MovimentazioniArticoliPk insert(MovimentazioniArticoli dto) throws MovimentazioniArticoliDaoException
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
			stmt.setLong( index++, dto.getMvdId() );
			stmt.setInt( index++, dto.getMvdQta() );
			stmt.setLong( index++, dto.getArticoloArtId() );
			stmt.setLong( index++, dto.getMovimentazioniMovId() );
			System.out.println( "Executing " + SQL_INSERT + " with DTO: " + dto );
			int rows = stmt.executeUpdate();
			long t2 = System.currentTimeMillis();
			System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
			reset(dto);
			return dto.createPk();
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new MovimentazioniArticoliDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Updates a single row in the movimentazioni_articoli table.
	 */
	public void update(MovimentazioniArticoliPk pk, MovimentazioniArticoli dto) throws MovimentazioniArticoliDaoException
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
			stmt.setLong( index++, dto.getMvdId() );
			stmt.setInt( index++, dto.getMvdQta() );
			stmt.setLong( index++, dto.getArticoloArtId() );
			stmt.setLong( index++, dto.getMovimentazioniMovId() );
			stmt.setLong( 5, pk.getMvdId() );
			int rows = stmt.executeUpdate();
			reset(dto);
			long t2 = System.currentTimeMillis();
			System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new MovimentazioniArticoliDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Deletes a single row in the movimentazioni_articoli table.
	 */
	public void delete(MovimentazioniArticoliPk pk) throws MovimentazioniArticoliDaoException
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
			stmt.setLong( 1, pk.getMvdId() );
			int rows = stmt.executeUpdate();
			long t2 = System.currentTimeMillis();
			System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new MovimentazioniArticoliDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Returns the rows from the movimentazioni_articoli table that matches the specified primary-key value.
	 */
	public MovimentazioniArticoli findByPrimaryKey(MovimentazioniArticoliPk pk) throws MovimentazioniArticoliDaoException
	{
		return findByPrimaryKey( pk.getMvdId() );
	}

	/** 
	 * Returns all rows from the movimentazioni_articoli table that match the criteria 'mvd_id = :mvdId'.
	 */
	public MovimentazioniArticoli findByPrimaryKey(long mvdId) throws MovimentazioniArticoliDaoException
	{
		MovimentazioniArticoli ret[] = findByDynamicSelect( SQL_SELECT + " WHERE mvd_id = ?", new Object[] {  new Long(mvdId) } );
		return ret.length==0 ? null : ret[0];
	}

	/** 
	 * Returns all rows from the movimentazioni_articoli table that match the criteria ''.
	 */
	public MovimentazioniArticoli[] findAll() throws MovimentazioniArticoliDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " ORDER BY mvd_id", null );
	}

	/** 
	 * Returns all rows from the movimentazioni_articoli table that match the criteria 'articolo_art_id = :articoloArtId'.
	 */
	public MovimentazioniArticoli[] findByArticolo(long articoloArtId) throws MovimentazioniArticoliDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE articolo_art_id = ?", new Object[] {  new Long(articoloArtId) } );
	}

	/** 
	 * Returns all rows from the movimentazioni_articoli table that match the criteria 'movimentazioni_mov_id = :movimentazioniMovId'.
	 */
	public MovimentazioniArticoli[] findByMovimentazioni(long movimentazioniMovId) throws MovimentazioniArticoliDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE movimentazioni_mov_id = ?", new Object[] {  new Long(movimentazioniMovId) } );
	}

	/** 
	 * Returns all rows from the movimentazioni_articoli table that match the criteria 'mvd_id = :mvdId'.
	 */
	public MovimentazioniArticoli[] findWhereMvdIdEquals(long mvdId) throws MovimentazioniArticoliDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE mvd_id = ? ORDER BY mvd_id", new Object[] {  new Long(mvdId) } );
	}

	/** 
	 * Returns all rows from the movimentazioni_articoli table that match the criteria 'mvd_qta = :mvdQta'.
	 */
	public MovimentazioniArticoli[] findWhereMvdQtaEquals(int mvdQta) throws MovimentazioniArticoliDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE mvd_qta = ? ORDER BY mvd_qta", new Object[] {  new Integer(mvdQta) } );
	}

	/** 
	 * Returns all rows from the movimentazioni_articoli table that match the criteria 'articolo_art_id = :articoloArtId'.
	 */
	public MovimentazioniArticoli[] findWhereArticoloArtIdEquals(long articoloArtId) throws MovimentazioniArticoliDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE articolo_art_id = ? ORDER BY articolo_art_id", new Object[] {  new Long(articoloArtId) } );
	}

	/** 
	 * Returns all rows from the movimentazioni_articoli table that match the criteria 'movimentazioni_mov_id = :movimentazioniMovId'.
	 */
	public MovimentazioniArticoli[] findWhereMovimentazioniMovIdEquals(long movimentazioniMovId) throws MovimentazioniArticoliDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE movimentazioni_mov_id = ? ORDER BY movimentazioni_mov_id", new Object[] {  new Long(movimentazioniMovId) } );
	}

	/**
	 * Method 'MovimentazioniArticoliDaoImpl'
	 * 
	 */
	public MovimentazioniArticoliDaoImpl()
	{
	}

	/**
	 * Method 'MovimentazioniArticoliDaoImpl'
	 * 
	 * @param userConn
	 */
	public MovimentazioniArticoliDaoImpl(final java.sql.Connection userConn)
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
		return "movimentazioni_articoli";
	}

	/** 
	 * Fetches a single row from the result set
	 */
	protected MovimentazioniArticoli fetchSingleResult(ResultSet rs) throws SQLException
	{
		if (rs.next()) {
			MovimentazioniArticoli dto = new MovimentazioniArticoli();
			populateDto( dto, rs);
			return dto;
		} else {
			return null;
		}
		
	}

	/** 
	 * Fetches multiple rows from the result set
	 */
	protected MovimentazioniArticoli[] fetchMultiResults(ResultSet rs) throws SQLException
	{
		Collection resultList = new ArrayList();
		while (rs.next()) {
			MovimentazioniArticoli dto = new MovimentazioniArticoli();
			populateDto( dto, rs);
			resultList.add( dto );
		}
		
		MovimentazioniArticoli ret[] = new MovimentazioniArticoli[ resultList.size() ];
		resultList.toArray( ret );
		return ret;
	}

	/** 
	 * Populates a DTO with data from a ResultSet
	 */
	protected void populateDto(MovimentazioniArticoli dto, ResultSet rs) throws SQLException
	{
		dto.setMvdId( rs.getLong( COLUMN_MVD_ID ) );
		dto.setMvdQta( rs.getInt( COLUMN_MVD_QTA ) );
		dto.setArticoloArtId( rs.getLong( COLUMN_ARTICOLO_ART_ID ) );
		dto.setMovimentazioniMovId( rs.getLong( COLUMN_MOVIMENTAZIONI_MOV_ID ) );
	}

	/** 
	 * Resets the modified attributes in the DTO
	 */
	protected void reset(MovimentazioniArticoli dto)
	{
	}

	/** 
	 * Returns all rows from the movimentazioni_articoli table that match the specified arbitrary SQL statement
	 */
	public MovimentazioniArticoli[] findByDynamicSelect(String sql, Object[] sqlParams) throws MovimentazioniArticoliDaoException
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
			throw new MovimentazioniArticoliDaoException( "Exception: " + _e.getMessage(), _e );
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
	 * Returns all rows from the movimentazioni_articoli table that match the specified arbitrary SQL statement
	 */
	public MovimentazioniArticoli[] findByDynamicWhere(String sql, Object[] sqlParams) throws MovimentazioniArticoliDaoException
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
			throw new MovimentazioniArticoliDaoException( "Exception: " + _e.getMessage(), _e );
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
