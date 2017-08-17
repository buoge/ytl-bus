package com.lantaiyuan.ebus.custom.service;

import java.util.Map;
import com.lantaiyuan.ebus.custom.model.BaseBus;

public interface BusServiceI {
	Map<String, BaseBus> getBusMap();
}