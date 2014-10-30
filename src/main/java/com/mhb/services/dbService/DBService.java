package com.mhb.services.dbService;

import com.mhb.services.domain.JSONReturn;
import com.mhb.services.exception.TableNameErrorException;

public interface DBService {
	JSONReturn findAll(String table);
 }
