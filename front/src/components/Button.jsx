export default function Button({btnValue, onclickFunction, bgColor}){

    const style = {
        btn : {
            backgroundColor: bgColor,
            color: 'white',
            margin: '0.5rem auto',
            fontSize: '0.8rem',
            border: '2px double darkcyan',
            width: '100px',
            display: 'flex',
            justifyContent: 'center',
            cursor: 'pointer'
        }

    }

    return(
        <button onClick={onclickFunction} style={style.btn}>{btnValue}</button>
    )

}

Button.defaultProps = {
    bgColor: 'cadetblue'
}
