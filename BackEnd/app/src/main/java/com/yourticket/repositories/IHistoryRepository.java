package com.yourticket.repositories;

import com.yourticket.entities.HistoryEntity;

/**
 *
 * @author fredd
 */
public interface IHistoryRepository {
    public boolean saveHistory(HistoryEntity history);
}
