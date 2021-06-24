export class User{
    constructor(
        public id: number,
        public name: string,
        public address: string,
        public mobile: string,
        public email: string,
        public username: string,
        public password: string,
        public isAdmin:boolean = false
    ){ }

    public getUserId(){
        return this.id;
    }

    public getName(){
        return this.name;
    }

    public getAddress(){
        return this.address;
    }

    public getMobile(){
        return this.mobile;
    }

    public getEmail(){
        return this.email;
    }

    public getUsername(){
        return this.username;
    }

    public getPassword(){
        return this.password;
    }
}