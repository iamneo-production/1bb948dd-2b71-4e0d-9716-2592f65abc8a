import axios from 'axios';
import React, { useContext, useEffect, useState } from 'react';
import AuthContext from '../Authentication/AuthContext';

const Orders = (props) => {

    const [state, setState] = useState({
        orders : []
    })

    const [refresh, setRefresh] = useState(true);

    const authContent = useContext(AuthContext);

    const credentials = authContent.state.auth;

    useEffect(() => {
        axios.get(`https://8080-dbaeccffaaaeaaeeaebaabacbcadcbdc.project.examly.io/user/${credentials.username}/orders`)
        .then(res => {
            if(res.data) {
                setState({orders : res.data});
            }
        })
    })

    useEffect(() => {
        axios.get(`https://8080-dbaeccffaaaeaaeeaebaabacbcadcbdc.project.examly.io/getAllOrders`)
        .then(res => {
            if(res.data) {
                setState({orders : res.data});
            }
        })
    })

    const clearAll = () => {
        axios.delete(`https://8080-dbaeccffaaaeaaeeaebaabacbcadcbdc.project.examly.io/user/deleteall`)
        .then(res => {
            authContent.notify('Order history cleared', 'success');
            setRefresh(prevState => !prevState);
        })
    }

    const ordersList = state.orders.map(order => {

        return (
            <div className="container border px-3 shadow-lg bg-light my-4 rounded py-2">
                <ul className="list-group p-2 m-2 ">
                    <li className="list-group-item">Product Name : <b>{order.productName}</b></li>
                    <li className="list-group-item">Price : <b>{order.price}</b></li>
                    <li className="list-group-item">Quantity : <b>{order.quantity}</b></li>
                    <li className="list-group-item">Total Price  : <b>{(parseFloat(order.quantity) * parseFloat(order.price)).toFixed(2)}</b></li>
                </ul>
            </div>
            
        )

    })


    return ( 
        <>
            <div className="container-fluid mb-5 mt-4">
                {state.orders.length > 0 && <h2 className="text-center my-3">My Orders</h2>}

                <div className="container-fluid">
                    { (authContent.state.auth.role === 'ADMIN' && state.orders.length > 0) &&  
                        <div className="container">
                            <button className="btn btn-block btn-danger my-3" onClick={clearAll} style={{width : "10rem"}}>Clear All</button>
                        </div>
                    }

                    {state.orders.length < 1 ? <h2 className="text-center mx-auto my-5">No Orders to Display</h2> : ordersList}
                </div>

            </div>
        </>
     );
}
 
export default Orders;