package com.netapp.ads.converters;

import java.io.Serializable;

import org.springframework.data.rest.webmvc.spi.BackendIdConverter;
import org.springframework.stereotype.Component;

import com.netapp.ads.models.ActivityPresumedLobXRef;
import com.netapp.ads.models.ActivityPresumedLobXRefPK;

@Component
public class ActivityPresumedLobXRefIDConverter implements BackendIdConverter {

	@Override
	public boolean supports(Class<?> entity) {
		return entity.equals(ActivityPresumedLobXRef.class);
	}

	@Override
	public Serializable fromRequestId(String id, Class<?> entity) {
		System.out.println(getClass().getName() + ": fromRequestId: Entered: " + id + ", " + entity);
		if(id != null) {
			String[] stringKeys = id.split(Constants.CONVERTER_ID_URL_SEPARATOR);
			System.out.println(getClass().getName() + ": fromRequestId: stringKeys: " + stringKeys[0] + ", " + stringKeys[1]);
			return new ActivityPresumedLobXRefPK(Integer.parseInt(stringKeys[0]), Integer.parseInt(stringKeys[1]));
		}
		return id;
	}

	@Override
	public String toRequestId(Serializable serializableClass, Class<?> entity) {
		System.out.println(getClass().getName() + ": toRequestId: Entered: " + serializableClass + ", " + entity);
		if (entity.isAssignableFrom(ActivityPresumedLobXRef.class)) {
			ActivityPresumedLobXRefPK compositeKey = (ActivityPresumedLobXRefPK) serializableClass;
			String sReturn = String.format("%s-%s", compositeKey.getActivityId(), compositeKey.getLobId());
			System.out.println(getClass().getName() + ": toRequestId: sReturn: " + sReturn);
            return sReturn;
        }
        return BackendIdConverter.DefaultIdConverter.INSTANCE.toRequestId(serializableClass, entity);
	}

}
