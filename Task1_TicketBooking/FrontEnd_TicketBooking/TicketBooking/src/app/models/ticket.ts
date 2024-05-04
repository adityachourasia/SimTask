export class Ticket {

    ticketId!: String;
    fromStation!: String;
    toStation!: String;
    issuedTimeStamp!: Date;
    fare!: Number;
    status!: String;

    constructor(fromStation: String,
        toStation: String,
        fare: Number) {
        this.fromStation = fromStation;
        this.toStation = toStation;
        this.fare = fare;
    }



}
