/**
 * An object used to get page information from the server
 */
export class Page {
    //The number of elements in the page
    size: number = 0;
    //The total number of elements
    totalElements: number = 0;
    //The total number of pages
    totalPages: number = 0;
    //The current page number - This is the HATEOS standard
    number: number = 0;
    //The current page number - Our database modules uses pageNumber, most likely to no have a reserved word as a property
    pageNumber: number = 0;
  }