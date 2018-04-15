export class ActivtyResponse {
  isMultiOwner:boolean = false;
  
  callMe:boolean = false;
  isOwner:boolean = false;
  isPresumed: boolean = true;
  dontKnowOwner: boolean = true;
  decommissionVolume:boolean = false;
  decommissionByDate;

  suggestedOwnerUserCorporateId: number;
  suggestedOwnerUserCorporateResourceUrl: string;
  
  ownerUserCorporateId:number;
	currentUserCorporateId:number;
	
	activityResponseId:number;
}