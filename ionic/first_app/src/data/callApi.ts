import Vehicule from "../model/Vehicule";

export class callApi{


    getList=(url:string,method:string)=>{
        var list=undefined;
        fetch(url, {       
            method:method,
            headers: {'Content-Type': 'application/json'},
        }).then(response=>response.json()).then(data=>{list=(data)});
        return list;
    }

}


export default callApi;

