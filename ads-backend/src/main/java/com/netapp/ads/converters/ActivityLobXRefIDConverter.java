package com.netapp.ads.converters;

import java.io.Serializable;

import org.springframework.data.rest.webmvc.spi.BackendIdConverter;
import org.springframework.stereotype.Component;

import com.netapp.ads.models.ActivityLobXRef;
import com.netapp.ads.models.ActivityLobXRefPK;

@Component
public class ActivityLobXRefIDConverter implements BackendIdConverter {

	@Override
	public boolean supports(Class<?> entity) {
		return entity.equals(ActivityLobXRef.class);
	}

	@Override
	public Serializable fromRequestId(String id, Class<?> entity) {
		System.out.println(getClass().getName() + ": fromRequestId: Entered: " + id + ", " + entity);
		if(id != null) {
			String[] stringKeys = id.split(Constants.CONVERTER_ID_URL_SEPARATOR);
			System.out.println(getClass().getName() + ": fromRequestId: stringKeys: " + stringKeys[0] + ", " + stringKeys[1]);
			return new ActivityLobXRefPK(Integer.parseInt(stringKeys[0]), Integer.parseInt(stringKeys[1]));
		}
		return id;
	}

	@Override
	public String toRequestId(Serializable serializableClass, Class<?> entity) {
		System.out.println(getClass().getName() + ": toRequestId: Entered: " + serializableClass + ", " + entity);
		if (entity.isAssignableFrom(ActivityLobXRef.class)) {
			ActivityLobXRefPK compositeKey = (ActivityLobXRefPK) serializableClass;
			String sReturn = String.format("%s-%s", compositeKey.getActivityId(), compositeKey.getLobId());
			System.out.println(getClass().getName() + ": toRequestId: sReturn: " + sReturn);
            return sReturn;
        }
        return BackendIdConverter.DefaultIdConverter.INSTANCE.toRequestId(serializableClass, entity);
	}

}
