package com.netapp.ads.rules.engine;

import java.util.List;

import com.netapp.ads.models.Qtree;

public interface QtreeDispositionService {
	void executeQtreeDispositionRules(List<Qtree> qtrees);
}
