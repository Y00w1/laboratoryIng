package com.example.laboratorio.services.impl;

import com.example.laboratorio.model.Monitor;
import com.example.laboratorio.services.MonitorService;

public class MonitorServiceImpl implements MonitorService {
    int loans;
    private Monitor monitor = new Monitor("1234","Juan",loans);
    @Override
    public Monitor getMonitor() {
        return monitor;
    }

    public void setMonitor(Monitor monitor) {
        this.monitor = monitor;
    }
    @Override
    public void editLoans(){
        loans+=1;
        monitor.setLoans(loans);
    }

    @Override
    public Monitor monitorInformation() {
        return monitor;
    }
}
