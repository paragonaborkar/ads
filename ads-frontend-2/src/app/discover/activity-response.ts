export class ActivtyResponse {
  callMe:boolean = false;
  isOwner:boolean = false;
  isPresumed: boolean = true;
  dontKnowOwner: boolean = true;
  decommissionVolume:boolean = false;
  decommissionByDate;

  suggestedOwnerUserCorporateId: number;
  
  ownerUserCorporateId:number;
	currentUserCorporateId:number;
	
	activityResponseId:number;
}