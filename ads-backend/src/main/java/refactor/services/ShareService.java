/*******************************************************************************
 * Copyright (c) 2016, 2017 NetApp Inc. All Rights Reserved
 *
 * CONFIDENTIALITY NOTICE: 
 *     THIS SOFTWARE CONTAINS CONFIDENTIAL INFORMATION OF 
 *     NETAPP, INC. USE, DISCLOSURE OR REPRODUCTION IS PROHIBITED 
 *     WITHOUT THE PRIOR EXPRESS WRITTEN PERMISSION OF NETAPP, INC.
 *******************************************************************************/
package refactor.services;

import java.util.List;

import com.netapp.ads.exception.NetAppAdsException;
import com.netapp.ads.models.Share;


/**
 * API for the registering an Share asset.
 *
 */
public interface ShareService {

    /**
     * It creates the ShareEntity for the given migration activity. This method
     * adds an activity to the database.
     *
     * @param entity - the ShareEntity object to create.
     * @throws ApplicationException
     */
    void create(Share entity) throws NetAppAdsException;

    /**
     * Updates the ShareEntity for the given share.
     *
     * @param entity - the existing ShareEntity to update.
     * @return
     * @throws ApplicationException
     */
    Share update(Share entity) throws NetAppAdsException;

    /**
     * Deletes the ShareEntity from the database.
     *
     * @param entity - the ShareEntity object to be deleted.
     * @throws ApplicationException
     */
    void deleteById(Share entity) throws NetAppAdsException;

    /**
     * Finds the ShareEntity by identifier.
     *
     * @param id - the id identifier.
     * @return
     * @throws ApplicationException
     */
    Share getById(int id) throws NetAppAdsException;

    /**
     * Finds all the ShareEntity entries.
     *
     * @return
     * @throws ApplicationException
     */
    List<Share> getAll() throws NetAppAdsException;

    Long getHostCountByVol(int volId) throws NetAppAdsException;

    List<Share> getByVol(int volId) throws NetAppAdsException;
    
    List<String> getNameByVol(int volId) throws NetAppAdsException;
}
