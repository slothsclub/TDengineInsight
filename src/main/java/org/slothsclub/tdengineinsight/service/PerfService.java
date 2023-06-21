package org.slothsclub.tdengineinsight.service;

import org.slothsclub.tdengineinsight.TdengineService;
import org.slothsclub.tdengineinsight.mapper.PerfMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PerfService extends TdengineService {
    @Autowired
    PerfMapper perfMapper;
}
