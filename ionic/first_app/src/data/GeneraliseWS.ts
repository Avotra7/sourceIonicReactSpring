export class GeneraliseWS<T>{
    url !: string;
    method!:string;
    headers={'Content-Type': 'application/json'};
    requestbody!:any;


    GeneraliseWS(url:string,method:string,requestbody:any){
        this.url=url;
        this.method=method;
        this.requestbody=requestbody;
    }

    sendRequest(object:T){
        fetch(this.url, {       
            method:this.method,
            headers:this.headers,
        }).then(response=>response.json()).then(data=>{object=(data)});
    }

}