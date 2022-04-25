import React from "react";

const category = (props) => {
    return (
        <ul className={"list-group"}>
            {props.categories.map((term)=>{
                return(
                        <li className={"list-group-item"}> {term}</li>
                );
            })}
        </ul>
    )
}
export default category;