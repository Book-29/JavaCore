package ru.innopolis.attestation3.utils;

import ru.innopolis.attestation3.model.Patient;

public class ValidationUtils {
    public static boolean isValidPatientName(Patient patient) {
        return patient.getName() != null && !patient.getName().trim().isEmpty();
    }
   public static boolean isValidPhoneNumber(Patient patient) {
        return patient.getPhoneNumber() != null && !patient.getPhoneNumber().trim().isEmpty();
   }
    public static boolean isValidBirthDate(Patient patient) {
      return patient.getBirthData() != null;
   }


}
