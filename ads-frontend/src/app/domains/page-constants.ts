export class PageConstants {
    static USER: String = 'USER';
    static SYSTEM: String = 'SYSTEM';
    static USER_ADMIN = {
        key: 'UserAdmin',
        value: 'User Admin'
    };
    static USER_LISTING = {
        key: 'UserListing',
        value: 'User Listing'
    };

    static PAGES: Map<String, String> = new Map();

    constructor() {
        PageConstants.PAGES.set('UserAdmin', 'User Admin');
        PageConstants.PAGES.set('UserListing', 'User Listing');
    }
}
