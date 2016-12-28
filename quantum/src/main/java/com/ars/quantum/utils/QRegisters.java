package com.ars.quantum.utils;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.ars.complexnumbers.ComplexNumber;
import com.ars.gates.IGate;
import com.ars.qubits.QRegister;
import com.ars.qubits.Qubit;
import com.ars.qubits.QubitOne;
import com.ars.qubits.QubitZero;
import com.ars.qubits.RegisterOverflowException;

public class QRegisters {

	public static List<Qubit> fillWith(List<Qubit> list, Supplier<Qubit> qubitSupplier, int size) {
		list = Stream.generate(qubitSupplier).limit(size).collect(Collectors.toList());
		return list;
	}

	public static QRegister fillWith(QRegister reg, Supplier<Qubit> qubitSupplier) {
		reg.setQubits(Stream.generate(qubitSupplier).limit(reg.size()).collect(Collectors.toList()));
		return reg;
	}

	public static QRegister fillWithPattern(String pattern) throws RegisterOverflowException {
		QRegister qreg = new QRegister(pattern.length()).initialize();
		for (int i = 0; i < pattern.length(); i++) {
			if (pattern.charAt(i) == '1') {
				qreg.change(i, new QubitOne());
			} else {
				qreg.change(i, new QubitZero());
			}
		}
		return qreg;
	}

	public static QRegister applyGate(QRegister reg, IGate gate) {

		return applyGate(reg, gate.getUnitaryMatrix());
	}

	public static QRegister applyGate(QRegister reg, double[][] gate) {
		for (int i = 0; i < reg.size(); i++) {
			reg.change(i, QuantumOperations.applyGate(reg.get(i), gate));
		}
		return reg;
	}

	public static QRegister applyGate(QRegister reg, ComplexNumber[][] gate) {
		for (int i = 0; i < reg.size(); i++) {
			reg.change(i, QuantumOperations.applyGate(reg.get(i), gate));
		}
		return reg;
	}

}
