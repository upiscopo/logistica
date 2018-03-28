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

public class ArticoloDaoImpl extends AbstractDAO implements ArticoloDao
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
	protected final String SQL_SELECT = "SELECT art_id, art_codice, art_descrizione, art_barcode, art_giacenza, art_agg_dt FROM " + getTableName() + "";

	/** 
	 * Finder methods will pass this value to the JDBC setMaxRows method
	 */
	protected int maxRows;

	/** 
	 * SQL INSERT statement for this table
	 */
	protected final String SQL_INSERT = "INSERT INTO " + getTableName() + " ( art_id, art_codice, art_descrizione, art_barcode, art_giacenza, art_agg_dt ) VALUES ( ?, ?, ?, ?, ?, ? )";

	/** 
	 * SQL UPDATE statement for this table
	 */
	protected final String SQL_UPDATE = "UPDATE " + getTableName() + " SET art_id = ?, art_codice = ?, art_descrizione = ?, art_barcode = ?, art_giacenza = ?, art_agg_dt = ? WHERE art_id = ?";

	/** 
	 * SQL DELETE statement for this table
	 */
	protected final String SQL_DELETE = "DELETE FROM " + getTableName() + " WHERE art_id = ?";

	/** 
	 * Index of column art_id
	 */
	protected static final int COLUMN_ART_ID = 1;

	/** 
	 * Index of column art_codice
	 */
	protected static final int COLUMN_ART_CODICE = 2;

	/** 
	 * Index of column art_descrizione
	 */
	protected static final int COLUMN_ART_DESCRIZIONE = 3;

	/** 
	 * Index of column art_barcode
	 */
	protected static final int COLUMN_ART_BARCODE = 4;

	/** 
	 * Index of column art_giacenza
	 */
	protected static final int COLUMN_ART_GIACENZA = 5;

	/** 
	 * Index of column art_agg_dt
	 */
	protected static final int COLUMN_ART_AGG_DT = 6;

	/** 
	 * Number of columns
	 */
	protected static final int NUMBER_OF_COLUMNS = 6;

	/** 
	 * Index of primary-key column art_id
	 */
	protected static final int PK_COLUMN_ART_ID = 1;

	/** 
	 * Inserts a new row in the articolo table.
	 */
	public ArticoloPk insert(Articolo dto) throws ArticoloDaoException
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
		
			stmt = conn.prepareStatement( "SELECT nextval('seq_articoli')" );
			rs = stmt.executeQuery();
			if (rs.next()) {
				dto.setArtId( rs.getLong( 1 ) );
				rs.close();
				stmt.close();
			}
		
			stmt = conn.prepareStatement( SQL_INSERT );
			int index = 1;
			stmt.setLong( index++, dto.getArtId() );
			stmt.setString( index++, dto.getArtCodice() );
			stmt.setString( index++, dto.getArtDescrizione() );
			stmt.setString( index++, dto.getArtBarcode() );
			if (dto.isArtGiacenzaNull()) {
				stmt.setNull( index++, java.sql.Types.INTEGER );
			} else {
				stmt.setInt( index++, dto.getArtGiacenza() );
			}
		
			stmt.setDate(index++, dto.getArtAggDt()==null ? null : new java.sql.Date( dto.getArtAggDt().getTime() ) );
			System.out.println( "Executing " + SQL_INSERT + " with DTO: " + dto );
			int rows = stmt.executeUpdate();
			long t2 = System.currentTimeMillis();
			System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
			reset(dto);
			return dto.createPk();
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new ArticoloDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Updates a single row in the articolo table.
	 */
	public void update(ArticoloPk pk, Articolo dto) throws ArticoloDaoException
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
			stmt.setLong( index++, dto.getArtId() );
			stmt.setString( index++, dto.getArtCodice() );
			stmt.setString( index++, dto.getArtDescrizione() );
			stmt.setString( index++, dto.getArtBarcode() );
			if (dto.isArtGiacenzaNull()) {
				stmt.setNull( index++, java.sql.Types.INTEGER );
			} else {
				stmt.setInt( index++, dto.getArtGiacenza() );
			}
		
			stmt.setDate(index++, dto.getArtAggDt()==null ? null : new java.sql.Date( dto.getArtAggDt().getTime() ) );
			stmt.setLong( 7, pk.getArtId() );
			int rows = stmt.executeUpdate();
			reset(dto);
			long t2 = System.currentTimeMillis();
			System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new ArticoloDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Deletes a single row in the articolo table.
	 */
	public void delete(ArticoloPk pk) throws ArticoloDaoException
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
			stmt.setLong( 1, pk.getArtId() );
			int rows = stmt.executeUpdate();
			long t2 = System.currentTimeMillis();
			System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new ArticoloDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Returns the rows from the articolo table that matches the specified primary-key value.
	 */
	public Articolo findByPrimaryKey(ArticoloPk pk) throws ArticoloDaoException
	{
		return findByPrimaryKey( pk.getArtId() );
	}

	/** 
	 * Returns all rows from the articolo table that match the criteria 'art_id = :artId'.
	 */
	public Articolo findByPrimaryKey(long artId) throws ArticoloDaoException
	{
		Articolo ret[] = findByDynamicSelect( SQL_SELECT + " WHERE art_id = ?", new Object[] {  new Long(artId) } );
		return ret.length==0 ? null : ret[0];
	}

	/** 
	 * Returns all rows from the articolo table that match the criteria ''.
	 */
	public Articolo[] findAll() throws ArticoloDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " ORDER BY art_id", null );
	}

	/** 
	 * Returns all rows from the articolo table that match the criteria 'art_id = :artId'.
	 */
	public Articolo[] findWhereArtIdEquals(long artId) throws ArticoloDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE art_id = ? ORDER BY art_id", new Object[] {  new Long(artId) } );
	}

	/** 
	 * Returns all rows from the articolo table that match the criteria 'art_codice = :artCodice'.
	 */
	public Articolo[] findWhereArtCodiceEquals(String artCodice) throws ArticoloDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE art_codice = ? ORDER BY art_codice", new Object[] { artCodice } );
	}

	/** 
	 * Returns all rows from the articolo table that match the criteria 'art_descrizione = :artDescrizione'.
	 */
	public Articolo[] findWhereArtDescrizioneEquals(String artDescrizione) throws ArticoloDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE art_descrizione = ? ORDER BY art_descrizione", new Object[] { artDescrizione } );
	}

	/** 
	 * Returns all rows from the articolo table that match the criteria 'art_barcode = :artBarcode'.
	 */
	public Articolo[] findWhereArtBarcodeEquals(String artBarcode) throws ArticoloDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE art_barcode = ? ORDER BY art_barcode", new Object[] { artBarcode } );
	}

	/** 
	 * Returns all rows from the articolo table that match the criteria 'art_giacenza = :artGiacenza'.
	 */
	public Articolo[] findWhereArtGiacenzaEquals(int artGiacenza) throws ArticoloDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE art_giacenza = ? ORDER BY art_giacenza", new Object[] {  new Integer(artGiacenza) } );
	}

	/** 
	 * Returns all rows from the articolo table that match the criteria 'art_agg_dt = :artAggDt'.
	 */
	public Articolo[] findWhereArtAggDtEquals(Date artAggDt) throws ArticoloDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE art_agg_dt = ? ORDER BY art_agg_dt", new Object[] { artAggDt==null ? null : new java.sql.Date( artAggDt.getTime() ) } );
	}

	/**
	 * Method 'ArticoloDaoImpl'
	 * 
	 */
	public ArticoloDaoImpl()
	{
	}

	/**
	 * Method 'ArticoloDaoImpl'
	 * 
	 * @param userConn
	 */
	public ArticoloDaoImpl(final java.sql.Connection userConn)
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
		return "articolo";
	}

	/** 
	 * Fetches a single row from the result set
	 */
	protected Articolo fetchSingleResult(ResultSet rs) throws SQLException
	{
		if (rs.next()) {
			Articolo dto = new Articolo();
			populateDto( dto, rs);
			return dto;
		} else {
			return null;
		}
		
	}

	/** 
	 * Fetches multiple rows from the result set
	 */
	protected Articolo[] fetchMultiResults(ResultSet rs) throws SQLException
	{
		Collection resultList = new ArrayList();
		while (rs.next()) {
			Articolo dto = new Articolo();
			populateDto( dto, rs);
			resultList.add( dto );
		}
		
		Articolo ret[] = new Articolo[ resultList.size() ];
		resultList.toArray( ret );
		return ret;
	}

	/** 
	 * Populates a DTO with data from a ResultSet
	 */
	protected void populateDto(Articolo dto, ResultSet rs) throws SQLException
	{
		dto.setArtId( rs.getLong( COLUMN_ART_ID ) );
		dto.setArtCodice( rs.getString( COLUMN_ART_CODICE ) );
		dto.setArtDescrizione( rs.getString( COLUMN_ART_DESCRIZIONE ) );
		dto.setArtBarcode( rs.getString( COLUMN_ART_BARCODE ) );
		dto.setArtGiacenza( rs.getInt( COLUMN_ART_GIACENZA ) );
		if (rs.wasNull()) {
			dto.setArtGiacenzaNull( true );
		}
		
		dto.setArtAggDt( rs.getDate(COLUMN_ART_AGG_DT ) );
	}

	/** 
	 * Resets the modified attributes in the DTO
	 */
	protected void reset(Articolo dto)
	{
	}

	/** 
	 * Returns all rows from the articolo table that match the specified arbitrary SQL statement
	 */
	public Articolo[] findByDynamicSelect(String sql, Object[] sqlParams) throws ArticoloDaoException
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
			throw new ArticoloDaoException( "Exception: " + _e.getMessage(), _e );
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
	 * Returns all rows from the articolo table that match the specified arbitrary SQL statement
	 */
	public Articolo[] findByDynamicWhere(String sql, Object[] sqlParams) throws ArticoloDaoException
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
			throw new ArticoloDaoException( "Exception: " + _e.getMessage(), _e );
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
