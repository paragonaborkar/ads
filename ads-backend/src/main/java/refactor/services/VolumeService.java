/*******************************************************************************
 * Copyright (c) 2016 NetApp Inc. All Rights Reserved
 *
 * CONFIDENTIALITY NOTICE: 
 *     THIS SOFTWARE CONTAINS CONFIDENTIAL INFORMATION OF 
 *     NETAPP, INC. USE, DISCLOSURE OR REPRODUCTION IS PROHIBITED 
 *     WITHOUT THE PRIOR EXPRESS WRITTEN PERMISSION OF NETAPP, INC.
 *******************************************************************************/
package refactor.services;

import java.util.List;

import com.netapp.ads.exception.NetAppAdsException;
import com.netapp.ads.models.NasVolume;


/**
 * API for the registering an Volume.
 *
 */
public interface VolumeService {

    /**
     * It creates the VolumeEntry for the given migration activity. This method
     * adds an volume to the database.
     *
     * @param entity - the VolumeEntry object to create.
     * @throws ApplicationException
     */
    void create(NasVolume entity) throws NetAppAdsException;

    /**
     * Updates the VolumeEntry for the given migration activity.
     *
     * @param entity - the existing VolumeEntry to update.
     * @return
     * @throws ApplicationException
     */
    NasVolume update(NasVolume entity) throws NetAppAdsException;

    /**
     * Deletes the VolumeEntry from the database.
     *
     * @param entity - the VolumeEntity object to be deleted.
     * @throws ApplicationException
     */
    void deleteById(NasVolume entity) throws NetAppAdsException;

    /**
     * Finds the VolumeEntry by volume identifier.
     *
     * @param id - the VolumeEntity identifier.
     * @return
     * @throws ApplicationException
     */
    NasVolume getById(int id) throws NetAppAdsException;

    /**
     * Finds all the VolumeEntry entries.
     *
     * @return
     * @throws ApplicationException
     */
    List<NasVolume> getAll() throws NetAppAdsException;

    List<NasVolume> getByCtrlId(int ctrlId) throws NetAppAdsException;

    int updateDispositionById(int id, String disp, String note) throws NetAppAdsException;
    
    Long getCountByCtrlId(int contrlId) throws NetAppAdsException;
}
