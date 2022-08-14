package model;

import lombok.Data;

@Data
// * Uçuş bilgileri parametreleri
public class Parameters {
    // * origin: nereden bilgisi
    String origin;
    // * destination: nereye bilgisi
    String destination;
    // * departureDay: gidiş tarihi bilgisi (bugünden itibaren kaç sonra olucak şekilde
    // * alınacak. Örnek: 10)
    Integer departureDay;
    // * returnDay: dönüş tarihi bilgisi (gidişten itibaren kaç gün sonra olucak şekilde
    // * alıncak. Örnek: 5 )
    Integer returnDay;
    // * provider: hangi provider’a ait uçuşun seçileceği
    String provider;
    // * isDirect:  True ise direkt uçuşlar seçilecek. False ise
    // * aktarmalı uçuşlar seçilecek.
    Boolean isDirect;
}
