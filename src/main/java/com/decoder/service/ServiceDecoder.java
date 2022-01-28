package com.decoder.service;


import com.decoder.Main;


public class ServiceDecoder {

    boolean skip = false;

    boolean isUpperChar = false;

    private final char[] punctuationMarks = {'\n', ',', ' ', '.'};

    private final char[] cipherTextChar = Main.cipherText.toCharArray();

    private final String lowerCaseCharacters = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";

    private final String upperCaseCharacters = lowerCaseCharacters.toUpperCase();


    public void decoderCaesar() {
        StringBuilder cipherTextResult = new StringBuilder();
        int step;

        for(char encodedCharacter : cipherTextChar) {

            for(char punctuationChar : punctuationMarks) {

                if(encodedCharacter == punctuationChar) {
                   cipherTextResult.append(encodedCharacter);
                     skip = true;
                     break;
                }
            }
            if(!skip) {
                step = lowerCaseCharacters.indexOf(encodedCharacter);
                if (step == -1) {
                    step = upperCaseCharacters.indexOf(encodedCharacter);
                    isUpperChar = true;
                }
                 step += Main.shiftPosition;
                if (step > lowerCaseCharacters.length() - 1) {
                    step -= lowerCaseCharacters.length();
                }
                cipherTextResult.append(isUpperChar ? upperCaseCharacters.charAt(step) : lowerCaseCharacters.charAt(step));

                isUpperChar = false;
                } else {
                  skip = false;
              }
            }
        System.out.println(Main.shiftPosition + "\n");
        System.out.println(cipherTextResult +"\n");
        }

    }

