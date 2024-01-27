import SignOut from "./acess/SignOut";
import Logo from '../assets/img/LenouteLogo.png';
import { NavMenu } from "../components/common/NavMenu";


export default function Home(){

    return(

        <div className="home">
            <NavMenu activeChild={3}/>
             <SignOut/>
            <h1>Bem-vindo ao</h1>
            <img src={Logo} alt="" />
            <h2>Fique a vontade sr(a) {JSON.parse(localStorage.getItem("userData")).name}</h2>
        </div>
    )
}