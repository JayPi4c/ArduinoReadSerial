package com.JayPi4c;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import gnu.io.CommPortIdentifier;

public class CheckPorts {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		Enumeration thePorts = CommPortIdentifier.getPortIdentifiers();
		while (thePorts.hasMoreElements()) {
			CommPortIdentifier com = (CommPortIdentifier) thePorts.nextElement();
			switch (com.getPortType()) {
			case CommPortIdentifier.PORT_SERIAL:
				list.add(com.getName());
			}
		}

		for (String s : list) {
			System.out.println(s);
		}

	}
}
