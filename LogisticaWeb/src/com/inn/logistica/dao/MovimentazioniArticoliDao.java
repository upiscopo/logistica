/*
 * This source file was generated by FireStorm/DAO.
 * 
 * If you purchase a full license for FireStorm/DAO you can customize this header file.
 * 
 * For more information please visit http://www.codefutures.com/products/firestorm
 */

package com.inn.logistica.dao;

import com.inn.logistica.dto.*;
import com.inn.logistica.exceptions.*;

public interface MovimentazioniArticoliDao
{
	/** 
	 * Inserts a new row in the movimentazioni_articoli table.
	 */
	public MovimentazioniArticoliPk insert(MovimentazioniArticoli dto) throws MovimentazioniArticoliDaoException;

	/** 
	 * Updates a single row in the movimentazioni_articoli table.
	 */
	public void update(MovimentazioniArticoliPk pk, MovimentazioniArticoli dto) throws MovimentazioniArticoliDaoException;

	/** 
	 * Deletes a single row in the movimentazioni_articoli table.
	 */
	public void delete(MovimentazioniArticoliPk pk) throws MovimentazioniArticoliDaoException;

	/** 
	 * Returns the rows from the movimentazioni_articoli table that matches the specified primary-key value.
	 */
	public MovimentazioniArticoli findByPrimaryKey(MovimentazioniArticoliPk pk) throws MovimentazioniArticoliDaoException;

	/** 
	 * Returns all rows from the movimentazioni_articoli table that match the criteria 'mvd_id = :mvdId'.
	 */
	public MovimentazioniArticoli findByPrimaryKey(long mvdId) throws MovimentazioniArticoliDaoException;

	/** 
	 * Returns all rows from the movimentazioni_articoli table that match the criteria ''.
	 */
	public MovimentazioniArticoli[] findAll() throws MovimentazioniArticoliDaoException;

	/** 
	 * Returns all rows from the movimentazioni_articoli table that match the criteria 'articolo_art_id = :articoloArtId'.
	 */
	public MovimentazioniArticoli[] findByArticolo(long articoloArtId) throws MovimentazioniArticoliDaoException;

	/** 
	 * Returns all rows from the movimentazioni_articoli table that match the criteria 'movimentazioni_mov_id = :movimentazioniMovId'.
	 */
	public MovimentazioniArticoli[] findByMovimentazioni(long movimentazioniMovId) throws MovimentazioniArticoliDaoException;

	/** 
	 * Returns all rows from the movimentazioni_articoli table that match the criteria 'mvd_id = :mvdId'.
	 */
	public MovimentazioniArticoli[] findWhereMvdIdEquals(long mvdId) throws MovimentazioniArticoliDaoException;

	/** 
	 * Returns all rows from the movimentazioni_articoli table that match the criteria 'mvd_qta = :mvdQta'.
	 */
	public MovimentazioniArticoli[] findWhereMvdQtaEquals(int mvdQta) throws MovimentazioniArticoliDaoException;

	/** 
	 * Returns all rows from the movimentazioni_articoli table that match the criteria 'articolo_art_id = :articoloArtId'.
	 */
	public MovimentazioniArticoli[] findWhereArticoloArtIdEquals(long articoloArtId) throws MovimentazioniArticoliDaoException;

	/** 
	 * Returns all rows from the movimentazioni_articoli table that match the criteria 'movimentazioni_mov_id = :movimentazioniMovId'.
	 */
	public MovimentazioniArticoli[] findWhereMovimentazioniMovIdEquals(long movimentazioniMovId) throws MovimentazioniArticoliDaoException;

	/** 
	 * Sets the value of maxRows
	 */
	public void setMaxRows(int maxRows);

	/** 
	 * Gets the value of maxRows
	 */
	public int getMaxRows();

	/** 
	 * Returns all rows from the movimentazioni_articoli table that match the specified arbitrary SQL statement
	 */
	public MovimentazioniArticoli[] findByDynamicSelect(String sql, Object[] sqlParams) throws MovimentazioniArticoliDaoException;

	/** 
	 * Returns all rows from the movimentazioni_articoli table that match the specified arbitrary SQL statement
	 */
	public MovimentazioniArticoli[] findByDynamicWhere(String sql, Object[] sqlParams) throws MovimentazioniArticoliDaoException;

}
