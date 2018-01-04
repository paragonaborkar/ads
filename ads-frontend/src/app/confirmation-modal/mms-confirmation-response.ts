export class MmsConfirmationResponse {
	
    confirmed: boolean;
    action: string; 
    subject: Object;

    constructor(confirmed, action, subject) {
        this.confirmed = confirmed;
        this.action = action;
        this.subject = subject;
    } 
}